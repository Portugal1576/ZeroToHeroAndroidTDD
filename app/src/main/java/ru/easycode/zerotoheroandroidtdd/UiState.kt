package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {

    fun apply(textViev: TextView, button: Button)

    data class Base(private val text: String): UiState {
        override fun apply(textViev: TextView, button: Button) {
            textViev.text = text
        }
    }

    data class Max(private val text: String): UiState {

        override fun apply(textViev: TextView, button: Button) {
            textViev.text = text
            button.isEnabled = false
        }
    }
}