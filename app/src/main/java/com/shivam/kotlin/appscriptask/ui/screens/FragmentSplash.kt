package com.shivam.kotlin.appscriptask.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shivam.kotlin.appscriptask.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentSplash : Fragment() {

    private lateinit var startGameButton: Button
    private lateinit var history: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startGameButton = view.findViewById(R.id.btn_startGame);
        startGameButton.setOnClickListener {v->
            v.findNavController().navigate(R.id.action_fragmentSplash_to_fragment12)
        }

        history = view.findViewById(R.id.btn_showHistory)
        history.setOnClickListener { v->
            v.findNavController().navigate(R.id.action_fragmentSplash_to_fragmentHistory)
        }

    }

}