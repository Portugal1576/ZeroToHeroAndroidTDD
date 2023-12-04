package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState {

    fun apply(
        dicrementButton: Button,
        incrementButton: Button,
        countText: TextView
    )

    data class Base(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.text = text
            dicrementButton.isEnabled = true
            incrementButton.isEnabled = true
        }

    }

    data class Max(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.text = text
            dicrementButton.isEnabled = true
            incrementButton.isEnabled = false
        }

    }

    data class Min(private val text: String) : UiState {
        override fun apply(dicrementButton: Button, incrementButton: Button, countText: TextView) {
            countText.text = text
            incrementButton.isEnabled = true
            dicrementButton.isEnabled = false
        }
    }
}