package com.ray.schoolmidterm.publishDialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.ray.schoolmidterm.ActivityViewModel
import com.ray.schoolmidterm.R
import com.ray.schoolmidterm.databinding.FragmentPublishDialogBinding

/**
 * A simple [Fragment] subclass.
 */
class PublishDialog : Fragment() {



    val viewModel: PublishViewModel by lazy {
        ViewModelProvider(this).get(PublishViewModel::class.java)
    }

    private lateinit var binding: FragmentPublishDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return binding.root
    }



}

