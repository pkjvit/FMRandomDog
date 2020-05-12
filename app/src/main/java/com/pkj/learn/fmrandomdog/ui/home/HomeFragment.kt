package com.pkj.learn.fmrandomdog.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pkj.learn.fmrandomdog.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recents_dog_btn.setOnClickListener { openRecentDogsScreen() }
        generate_btn.setOnClickListener { openGenerateDogScreen() }
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
