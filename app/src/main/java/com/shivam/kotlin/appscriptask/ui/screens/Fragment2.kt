package com.shivam.kotlin.appscriptask.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shivam.kotlin.appscriptask.util.Constants
import com.shivam.kotlin.appscriptask.R
import com.shivam.kotlin.appscriptask.databinding.Fragment2Binding
import kotlinx.android.synthetic.main.fragment_2.view.*

class Fragment2 : Fragment() {

    private lateinit var binding:Fragment2Binding
    private val args: Fragment2Args by navArgs()
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val question = Constants.questionList[0]
        binding.question = question
        binding.next2.setOnClickListener { v->
           var answer =  when (binding.answer2Rg.checkedRadioButtonId){
                R.id.option_1_ques_2 -> question.option1
                R.id.option_2_ques_2 -> question.option2
                R.id.option_3_ques_2 -> question.option3
                R.id.option_4_ques_2 -> question.option4
                else-> null
            }

            if (answer == null){
                Toast.makeText(context,"Must Select a option",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val summary = args.summary
            summary.summary = "\n" + question.question + "\n" + answer + "\n"
            val action = Fragment2Directions.actionFragment2ToFragment3(summary)
            findNavController().navigate(action)
        }
    }
}
