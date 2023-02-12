package com.umutg.lolchampionsapp.presentation.champion_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutg.lolchampionsapp.common.Resource
import com.umutg.lolchampionsapp.domain.model.Champions
import com.umutg.lolchampionsapp.domain.use_case.FavoriteChampionsUseCase
import com.umutg.lolchampionsapp.domain.use_case.GetChampionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ChampionsViewModel @Inject constructor(
    private val useCase: GetChampionsUseCase
) : ViewModel() {

    val champions: LiveData<Resource<List<Champions>>> get() = _champions
    private val _champions = MutableLiveData<Resource<List<Champions>>>()

    init {
        loadChampions()
    }

    fun loadChampions() {

        _champions.value = Resource.Loading()

        viewModelScope.launch {

            delay(700)

            val resource = withContext(Dispatchers.Default) {
                try {
                    val champions = useCase.getAllChampions()
                    Resource.Success(champions)
                } catch (exception: Exception) {
                    Resource.Error(exception.message)
                }
            }
            _champions.value = resource
        }
    }

}