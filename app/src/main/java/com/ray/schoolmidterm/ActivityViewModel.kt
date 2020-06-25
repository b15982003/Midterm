package com.ray.schoolmidterm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.ray.schoolmidterm.data.PostData
import kotlinx.android.synthetic.*
import java.text.SimpleDateFormat
import java.util.*

class ActivityViewModel :ViewModel() {

    val db = FirebaseFirestore.getInstance()


    val post = MutableLiveData<List<PostData>>()

    init {
        readData()
    }

    fun readData() {

        db.collection("articles")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val list = mutableListOf<PostData>()
                    for (document in task.result!!) {
                        Log.d("Ray", document.id + " => " + document.data)
                        val postData = PostData(
                            email = document.getString("email"),
                            title = document.getString("title"),
                            id = document.getString("author.id"),
                            name = document.getString("author.name"),
                            content = document.getString("content"),
                            createdTime = document.getLong("createdTime"),
                            documentid = document.getString("documentid"),
                            tag = document.getString("tag")
                        )
                        list.add(postData)
                        post.value = list

                    }
                } else {
                    Log.w("RAy", "Error getting documents.", task.exception)
                }
            }
    }
    fun getDateTime(s: Long): String? {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

}
