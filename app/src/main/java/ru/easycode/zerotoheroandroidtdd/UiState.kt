package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(
        dicrementButton: Button,
        incrementButton: Button,
        countText: TextView
    )

    data class Base(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.setText(text)
        }

    }

    data class Max(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.setText(text)
            dicrementButton.isEnabled = false
        }

    }

    data class Min(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.setText(text)
            incrementButton.isEnabled = false
        }
    }
}