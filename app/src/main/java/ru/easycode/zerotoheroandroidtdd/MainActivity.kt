package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var ll_text: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        ll_text = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            ll_text.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val status = ll_text.childCount
        outState.putInt(KEY, 1)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val status = savedInstanceState.getInt(KEY)
        if (status == 1) ll_text.removeView(textView)
    }

    companion object{
        private val KEY = "key"
    }
}