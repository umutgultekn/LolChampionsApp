package com.umutg.lolchampionsapp.presentation.champion_list

import com.umutg.lolchampionsapp.domain.model.Champions

interface ChampionsItemClickListener {

    fun onClicked(champions: Champions)
}