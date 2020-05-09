package com.pkj.learn.fmrandomdog.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

import com.pkj.learn.fmrandomdog.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.recents_dog_btn).setOnClickListener { openRecentDogsScreen() }
        view.findViewById<Button>(R.id.generate_btn).setOnClickListener { openGenerateDogScreen() }
    }

    private fun openGenerateDogScreen(){
        val action = HomeFragmentDirections.actionHomeFragmentToGenerateDogFragment()
        findNavController().navigate(action)
    }

    private fun openRecentDogsScreen(){
        val action = HomeFragmentDirections.actionHomeFragmentToRecentsDogFragment()
        findNavController().navigate(action)
    }

}
