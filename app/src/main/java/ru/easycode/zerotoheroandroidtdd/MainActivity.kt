package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2, 4, 0)
    private lateinit var uiState: UiState
    private lateinit var decrementButton: Button
    private lateinit var incrementButton: Button
    private lateinit var countText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)
        countText = findViewById(R.id.countTextView)

        decrementButton.setOnClickListener{
            uiState = count.decrement(countText.text.toString())
            uiState.apply(decrementButton, incrementButton, countText)
        }
        incrementButton.setOnClickListener{
            uiState = count.increment(countText.text.toString())
            uiState.apply(decrementButton, incrementButton, countText)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(countText.text.toString())
            uiState.apply(decrementButton, incrementButton, countText)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = count.initial(countText.text.toString())
        uiState.apply(decrementButton, incrementButton, countText)
    }
}