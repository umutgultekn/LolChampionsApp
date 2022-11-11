package com.umutg.lolchampionsapp.presentation.champion_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umutg.lolchampionsapp.R

class ChampionDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ChampionDetailFragment()
    }

    private lateinit var viewModel: ChampionDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_champion_detail, container, false)
    }


}