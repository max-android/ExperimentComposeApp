package com.testsample.ru.data

class CheckListRepository(private val questionnaireStore: QuestionnaireStore) {

    var step: Int
        get() {
            return questionnaireStore.step
        }
        set(value) {
            questionnaireStore.step = value
        }

}