package com.umutg.lolchampionsapp.presentation.champion_details

import androidx.lifecycle.*
import com.umutg.lolchampionsapp.common.Constants.CHAMPION_KEY
import com.umutg.lolchampionsapp.common.Resource
import com.umutg.lolchampionsapp.data.database.entities.FavoriteChampionEntity
import com.umutg.lolchampionsapp.domain.model.Champion
import com.umutg.lolchampionsapp.domain.model.Champions
import com.umutg.lolchampionsapp.domain.use_case.FavoriteChampionsUseCase
import com.umutg.lolchampionsapp.domain.use_case.GetChampionDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ChampionDetailsViewModel @Inject constructor(
    private val useCase: GetChampionDetailsUseCase,
    private val favoriteChampionsUseCase: FavoriteChampionsUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val championDetail: LiveData<Resource<List<Champion>>> get() = _championDetail
    private val _championDetail = MutableLiveData<Resource<List<Champion>>>()

    val isFavoriteChampion: LiveData<Boolean> get() = _isFavoriteChampion
    private val _isFavoriteChampion = MutableLiveData(false)

    init {

//        savedStateHandle.get<Champions>(CHAMPION_KEY)?.let { champions ->
//            loadChampionDetails(champions.id)
//            isFavoriteChampion(champions.id)
//        }

        loadChampionDetails()
    }

    fun loadChampionDetails() {

        _championDetail.value = Resource.Loading()

        viewModelScope.launch {

            val resource = withContext(Dispatchers.Default) {
                try {
                    Resource.Success(
                        useCase.getChampionById(
                            savedStateHandle.get<Champions>(
                                CHAMPION_KEY
                            )?.id ?: ""
                        )
                    )
                } catch (exception: Exception) {
                    Resource.Error(exception.message)
                }
            }
            _championDetail.value = resource
        }
    }


    private fun isFavoriteChampion(id: String) {

        viewModelScope.launch(Dispatchers.IO) {

            if (favoriteChampionsUseCase.findByName(id) != null) {
                _isFavoriteChampion.postValue(true)
            }
        }
    }

    fun addToFavorites(favoriteChampionEntity: FavoriteChampionEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            favoriteChampionsUseCase.saveFavoriteChampion(favoriteChampionEntity)
        }
    }

    fun deleteFromFavorites(favoriteChampionEntity: FavoriteChampionEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            favoriteChampionsUseCase.deleteFavoriteChampion(favoriteChampionEntity)
        }
    }
}