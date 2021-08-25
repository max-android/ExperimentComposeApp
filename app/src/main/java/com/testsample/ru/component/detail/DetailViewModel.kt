package com.testsample.ru.component.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.testsample.ru.data.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel() {

    init {
        Log.i("--VM","-------------DetailViewModel----------")
    }


}