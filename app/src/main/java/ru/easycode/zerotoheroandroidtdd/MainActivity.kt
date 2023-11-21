package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var titleTextView = findViewById<TextView>(R.id.titleTextView)
        findViewById<Button>(R.id.changeButton).setOnClickListener {
            titleTextView.text = "I am an Android Developer!"
        }
    }
}