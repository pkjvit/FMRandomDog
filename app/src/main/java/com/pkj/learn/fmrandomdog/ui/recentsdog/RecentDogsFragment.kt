package com.pkj.learn.fmrandomdog.ui.recentsdog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkj.learn.fmrandomdog.DogApp
import com.pkj.learn.fmrandomdog.R
import kotlinx.android.synthetic.main.recents_dog_fragment.*
import javax.inject.Inject

class RecentDogsFragment : Fragment() {

    @Inject
    lateinit var viewModel: RecentDogsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as DogApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recents_dog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
        setupRecyclerView()
        setupListeners()
        viewModel.getRecentDogs()
    }

    private fun setupListeners() {
        clear_btn.setOnClickListener { viewModel.clear() }
    }

    private fun setupObserver() {
        viewModel.recentDogs.observe(viewLifecycleOwner, Observer {
            (recyclerView.adapter as RecentDogsAdapter).submitList(it)
        })
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = RecentDogsAdapter()
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(DogItemsDecoration(requireContext(), LinearLayoutManager.HORIZONTAL))
        }
    }


}
