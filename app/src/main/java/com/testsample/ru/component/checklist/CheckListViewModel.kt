package com.testsample.ru.component.checklist

import androidx.lifecycle.ViewModel
import com.testsample.ru.data.CheckListRepository
import com.testsample.ru.data.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckListViewModel @Inject constructor(
    private val repository: CheckListRepository
) : ViewModel() {

    init {

    }

    fun setStep(currentStep: Int) {
        repository.step = currentStep
    }

}