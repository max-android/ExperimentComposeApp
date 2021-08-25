package com.testsample.ru.component.list

import android.util.Log
import androidx.lifecycle.ViewModel
import com.testsample.ru.data.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ListRepository
) : ViewModel() {

    init {
        Log.i("--VM","-------------ListViewModel----------")
    }

}