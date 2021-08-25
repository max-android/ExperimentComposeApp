package com.testsample.ru.component.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.testsample.ru.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    init {
        Log.i("--VM","-------------HomeViewModel----------")
    }

}