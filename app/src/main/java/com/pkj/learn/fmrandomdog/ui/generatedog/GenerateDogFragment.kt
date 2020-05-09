package com.pkj.learn.fmrandomdog.ui.generatedog

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.pkj.learn.fmrandomdog.DogApp
import com.pkj.learn.fmrandomdog.R
import kotlinx.android.synthetic.main.generate_dog_fragment.*
import javax.inject.Inject


class GenerateDogFragment : Fragment() {

    @Inject
    lateinit var viewModel: GenerateDogViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as DogApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.generate_dog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        setupListeners()
    }

    private fun setupListeners() {
        generate_btn.setOnClickListener {
            generate_btn.isEnabled = false
            viewModel.getRandomDog()
        }
    }

    private fun setupObserver(){
        viewModel.response.observe(viewLifecycleOwner, Observer {
            Glide
                .with(requireContext())
                .load(it.message)
                .into(image)
        })

        viewModel.isLoading.observe( viewLifecycleOwner, Observer {
            generate_btn.isEnabled = !it
        })
    }

}
