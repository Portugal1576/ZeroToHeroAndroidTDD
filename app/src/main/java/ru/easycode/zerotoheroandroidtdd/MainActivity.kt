package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.actionButton)
        progressBar.visibility = View.INVISIBLE
        textView.visibility = View.INVISIBLE


        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            CoroutineScope(Dispatchers.Main).launch {
                delay(3500)
                progressBar.visibility = View.INVISIBLE
                button.isEnabled = true
                textView.visibility = View.VISIBLE
            }
        }
    }
}