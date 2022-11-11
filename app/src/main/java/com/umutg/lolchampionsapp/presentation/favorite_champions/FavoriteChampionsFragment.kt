package com.umutg.lolchampionsapp.presentation.favorite_champions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutg.lolchampionsapp.R

class FavoriteChampionsFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteChampionsFragment()
    }

    private lateinit var viewModel: FavoriteChampionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_champions, container, false)
    }


}