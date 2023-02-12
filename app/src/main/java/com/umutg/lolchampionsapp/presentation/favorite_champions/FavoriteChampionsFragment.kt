package com.umutg.lolchampionsapp.presentation.favorite_champions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.umutg.lolchampionsapp.R
import com.umutg.lolchampionsapp.databinding.FragmentFavoriteChampionsBinding
import com.umutg.lolchampionsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FavoriteChampionsFragment :
    BaseFragment<FragmentFavoriteChampionsBinding>(FragmentFavoriteChampionsBinding::inflate) {

    private val viewModel: FavoriteChampionsViewModel by viewModels()
    private val adapter = FavoriteChampionsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.itemAnimator = null
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

        itemTouchHelper()

        viewModel.favChampions.observe(viewLifecycleOwner) { favoriteChampions ->

            if (favoriteChampions.isNotEmpty()) {

                binding.tvNoFavoriteChampion.visibility = View.GONE
                adapter.submitList(favoriteChampions)

            } else {
                binding.tvNoFavoriteChampion.visibility = View.VISIBLE
            }
        }

    }


    private fun itemTouchHelper() {

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                val favoriteChampionEntity = adapter.currentList[viewHolder.adapterPosition]

                viewModel.deleteFavoriteChampion(favoriteChampionEntity)

                Snackbar.make(
                    binding.recyclerView,
                    getString(R.string.favorite_champion_deleted, favoriteChampionEntity.name),
                    Snackbar.LENGTH_SHORT
                )
                    .setAction(
                        getString(R.string.undo)
                    ) {
                        viewModel.saveFavoriteChampion(favoriteChampionEntity)
                    }.show()
            }

        }).attachToRecyclerView(binding.recyclerView)
    }

}