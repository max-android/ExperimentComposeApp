package com.testsample.ru.data

class MainRepository (private val questionnaireStore: QuestionnaireStore) {

    fun step(): Int = questionnaireStore.step



}