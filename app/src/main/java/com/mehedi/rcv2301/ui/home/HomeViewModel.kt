package com.mehedi.rcv2301.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.rcv2301.models.Love
import com.mehedi.rcv2301.repositories.LoveRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: LoveRepo) : ViewModel() {

    fun getAllLove(): LiveData<MutableList<Love>> {

        return repo.getAllLove()

    }
    fun deleteLove(love: Love) {

        viewModelScope.launch {
            repo.deleteLove(love)

        }

    }


}