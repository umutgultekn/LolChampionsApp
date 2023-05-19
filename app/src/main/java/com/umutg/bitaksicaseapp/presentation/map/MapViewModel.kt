package com.umutg.bitaksicaseapp.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutg.bitaksicaseapp.common.Resource
import com.umutg.bitaksicaseapp.domain.model.Plane
import com.umutg.bitaksicaseapp.domain.use_case.GetPlanesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val useCase: GetPlanesUseCase
) : ViewModel() {

    val plane: LiveData<Resource<List<Plane>>> get() = _plane
    private val _plane = MutableLiveData<Resource<List<Plane>>>()

    init {
//        loadPlanes()
    }

    fun loadPlanes() {

        _plane.value = Resource.Loading()

        viewModelScope.launch {

//            delay(700)

            val resource = withContext(Dispatchers.IO) {
                try {
                    val champions = useCase.getPlanes(4545f,4545f)
                    Resource.Success(champions)
                } catch (exception: Exception) {
                    Resource.Error(exception.message)
                }
            }
            _plane.value = resource
        }
    }

}