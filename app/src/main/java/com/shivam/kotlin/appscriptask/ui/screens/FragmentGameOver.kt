package com.shivam.kotlin.appscriptask.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.shivam.kotlin.appscriptask.R
import com.shivam.kotlin.appscriptask.databinding.FragmentGameOverBinding
import com.shivam.kotlin.appscriptask.modal.Summary
import com.shivam.kotlin.appscriptask.view_models.GameOverViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentGameOver : Fragment(){

    private val viewModel : GameOverViewModel by viewModels()
    private lateinit var binding : FragmentGameOverBinding
    private val args: FragmentGameOverArgs by navArgs()
    private var finalSummary: Summary? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameOverBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null){
            finalSummary = args.summary
        }else{
            finalSummary = Gson().fromJson(savedInstanceState.getString("finalSummary"),Summary::class.java)
        }

        //Binding the views with the data
        binding.greet = "Hello ${finalSummary?.name}"
        binding.summary = "${finalSummary?.summary}"

        if (savedInstanceState == null){
            viewModel.insertSummaryData(finalSummary)
        }
        arguments?.clear()

        binding.restart.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("finalSummary",Gson().toJson(finalSummary))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        arguments?.clear()
    }
}