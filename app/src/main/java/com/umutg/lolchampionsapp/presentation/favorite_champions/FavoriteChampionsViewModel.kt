package com.umutg.lolchampionsapp.presentation.favorite_champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import com.umutg.lolchampionsapp.domain.use_case.FavoriteChampionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteChampionsViewModel @Inject constructor(
    private val useCase: FavoriteChampionsUseCase,
) : ViewModel() {

    val favChampions: LiveData<List<FavoriteChampionEntity>> get() = _favChampions
    private val _favChampions = MutableLiveData<List<FavoriteChampionEntity>>()

    init {
        loadFavoriteChampions()
    }

    private fun loadFavoriteChampions() {

        viewModelScope.launch(Dispatchers.IO) {
            _favChampions.postValue(useCase.getFavoriteChampions())
        }
    }


    fun deleteFavoriteChampion(favoriteChampionEntity: FavoriteChampionEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            useCase.deleteFavoriteChampion(favoriteChampionEntity)
            loadFavoriteChampions()
        }

    }

    fun saveFavoriteChampion(favoriteChampionEntity: FavoriteChampionEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            useCase.saveFavoriteChampion(favoriteChampionEntity)
            loadFavoriteChampions()
        }

    }

}