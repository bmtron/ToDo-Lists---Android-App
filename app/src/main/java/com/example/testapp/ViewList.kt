package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class ViewList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list)
        val title = intent.getStringExtra(SAVED_LIST_TITLE)
        val data = intent.getStringExtra(SAVED_LIST_DATA)

        val textTitle = findViewById<TextView>(R.id.view_list_title).apply {
            text = title
        }
        val textData = findViewById<TextView>(R.id.view_list_data).apply {
            text = data
        }
    }

    fun deleteEntry(view: View) {
        val title = intent.getStringExtra(SAVED_LIST_TITLE)
        println(title)
        for ((t, d) in map) {
            if (t == title) {
                map.remove(t)
                println("true")

            }
        }

        println(map)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
