package com.testsample.ru.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class QuestionnaireStore(private val context: Context) {

    private val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(PREF_QUESTIONNAIRE_STORE, Context.MODE_PRIVATE)

    var step: Int
        get() {
            return sharedPreferences.getInt(PREF_KEY_STEP, 1)
        }
        set(value) {
            sharedPreferences.edit { putInt(PREF_KEY_STEP, value) }
        }

    companion object {
        private const val PREF_QUESTIONNAIRE_STORE = "PREF_QUESTIONNAIRE_STORE"
        private const val PREF_KEY_STEP = "PREF_KEY_STEP"
    }

}