package com.shivam.kotlin.appscriptask.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shivam.kotlin.appscriptask.R
import com.shivam.kotlin.appscriptask.databinding.Fragment1Binding
import com.shivam.kotlin.appscriptask.modal.Summary


class Fragment1 : Fragment() {
    private lateinit var binding : Fragment1Binding
    private lateinit var name : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.next1.setOnClickListener { v->
            name = binding.answer1Et.text.toString()
            if (name.isNullOrEmpty()){
                Toast.makeText(context,"Name cannot be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val summary = Summary(name = name,startDate = System.currentTimeMillis())
            val action = Fragment1Directions.actionFragment12ToFragment2(summary)
            findNavController().navigate(action)
        }
    }

}