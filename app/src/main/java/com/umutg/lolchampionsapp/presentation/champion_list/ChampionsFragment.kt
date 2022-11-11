package com.umutg.lolchampionsapp.presentation.champion_list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutg.lolchampionsapp.common.State
import com.umutg.lolchampionsapp.databinding.FragmentChampionsBinding
import com.umutg.lolchampionsapp.domain.model.Champions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionsFragment : Fragment(), DefaultLifecycleObserver {

    companion object {
        fun newInstance() = ChampionsFragment()
    }

    private val viewModel: ChampionsViewModel by viewModels()

    private var _binding: FragmentChampionsBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChampionsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.recyclerView.adapter = ChampionsAdapter(listOf())
        binding.recyclerView.setHasFixedSize(true)
//        binding.recyclerView.layoutManager =  LinearLayoutManager(context)
//        val linearLayoutManager = LinearLayoutManager(context)
//        binding.recyclerView.layoutManager = linearLayoutManager.apply {
//            orientation = LinearLayoutManager.VERTICAL
//        }

        viewModel.champions.observe(viewLifecycleOwner) { state ->

            when (state) {

                is State.Success -> {
                    binding.recyclerView.adapter = state.data?.let { ChampionsAdapter(it) }
                }
                is State.Error -> {

                }
                is State.Loading -> {

                }
            }
        }



        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycle?.addObserver(this)
    }

    override fun onDetach() {
        activity?.lifecycle?.removeObserver(this)
        super.onDetach()
    }

}