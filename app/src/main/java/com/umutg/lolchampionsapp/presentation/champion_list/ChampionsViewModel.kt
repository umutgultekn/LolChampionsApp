package com.umutg.lolchampionsapp.presentation.champion_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutg.lolchampionsapp.common.State
import com.umutg.lolchampionsapp.domain.model.Champions
import com.umutg.lolchampionsapp.domain.use_case.champion_list.GetChampionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChampionsViewModel @Inject constructor(private val useCase: GetChampionsUseCase) :
    ViewModel() {

    val champions: LiveData<State<List<Champions>>> get() = _champions
    private val _champions = MutableLiveData<State<List<Champions>>>()

    init {
        loadChampions()
    }

    private fun loadChampions() {
        _champions.value = State.Loading<List<Champions>>()

        viewModelScope.launch {

            val state = withContext(Dispatchers.Default) {
                try {
                    val currenciesValue = useCase.getAllChampions()
                    State.Success(currenciesValue)
                } catch (exception: Exception) {
                    State.Error(exception.message)
                }
            }
            _champions.value = state
        }

    }
}