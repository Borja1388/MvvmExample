package com.example.home.ui.state

import com.example.home.ui.model.FactVo

sealed class HomeState {
    object Loading : HomeState()
    data class Success(val randomFactVo: FactVo) : HomeState()
    data class Error (val message: String) : HomeState()
}