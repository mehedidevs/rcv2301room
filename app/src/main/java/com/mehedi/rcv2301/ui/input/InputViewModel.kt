package com.mehedi.rcv2301.ui.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.rcv2301.models.Love
import com.mehedi.rcv2301.repositories.LoveRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(private val repo: LoveRepo ) : ViewModel() {


    fun createLove(love: Love) {

        viewModelScope.launch {
            repo.createLove(love)

        }

    }


    fun updateLove(love: Love) {

        viewModelScope.launch {
            repo.updateLove(love)

        }

    }



}