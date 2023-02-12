package com.umutg.lolchampionsapp.presentation.champion_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.umutg.lolchampionsapp.R
import com.umutg.lolchampionsapp.common.ErrorDialogListener
import com.umutg.lolchampionsapp.common.Resource
import com.umutg.lolchampionsapp.common.showErrorDialog
import com.umutg.lolchampionsapp.databinding.FragmentChampionsBinding
import com.umutg.lolchampionsapp.domain.model.Champions
import com.umutg.lolchampionsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionsFragment : BaseFragment<FragmentChampionsBinding>(FragmentChampionsBinding::inflate),
    ChampionsItemClickListener, View.OnClickListener {

    private val viewModel: ChampionsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabFavoriteChampions.setOnClickListener(this)
        binding.rvChampions.adapter = ChampionsAdapter(listOf(), this)
        binding.rvChampions.setHasFixedSize(true)

        viewModel.champions.observe(viewLifecycleOwner) { state ->

            when (state) {

                is Resource.Success -> {

                    binding.rvChampions.adapter = state.data?.let { ChampionsAdapter(it, this) }

                    showRecyclerView()
                }
                is Resource.Error -> {

                    showErrorDialog(requireContext(), state.message, object : ErrorDialogListener {
                        override fun onTryAgain() {
                            viewModel.loadChampions()
                        }
                    })
                }
                is Resource.Loading -> {

                    binding.shimmerLayout.startShimmer()

                }
            }
        }

    }


    override fun onClicked(champions: Champions) {

        findNavController().navigate(
            ChampionsFragmentDirections.actionChampionsPageToChampionDetailsPage(
                champions
            )
        )
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.fabFavoriteChampions -> {

                findNavController().navigate(
                    ChampionsFragmentDirections.actionChampionsPageToFavoriteChampionsPage()
                )
            }
        }
    }

    private fun showRecyclerView() {

        binding.shimmerLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
        binding.rvChampions.visibility = View.VISIBLE
    }


}