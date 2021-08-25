package com.testsample.ru.component.main

import androidx.lifecycle.ViewModel
import com.testsample.ru.data.MainRepository
import com.testsample.ru.navigation.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    init {

    }

    fun currentScreen(): String = when (repository.step()) {
        STEP_1 -> Screen.CheckList1.route
        STEP_2 -> Screen.CheckList2.route
        STEP_3 -> Screen.CheckList3.route
        STEP_FINAL -> Screen.HomeScreen.route
        else -> Screen.CheckList1.route
    }

    fun isPaywall(): Boolean = true

}