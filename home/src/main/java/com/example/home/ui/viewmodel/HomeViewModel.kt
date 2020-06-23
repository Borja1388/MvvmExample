package com.example.home.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.ui.model.toVo
import com.example.home.ui.state.HomeState
import com.example.remote.FactRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val randomFact: MutableLiveData<HomeState> = MutableLiveData<HomeState>()
    private val repository: FactRepository = FactRepository()

    val randomFactLiveData : LiveData<HomeState> = randomFact

    fun getRandomFact(){
        viewModelScope.launch {
            randomFact.postValue(HomeState.Loading)
            delay(3000)
            val randomFactResponse = repository.getRandomFact()
            randomFact.postValue(HomeState.Success(randomFactResponse.toVo()))
        }
    }
}


