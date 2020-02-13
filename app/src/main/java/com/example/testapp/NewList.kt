package com.example.testapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_TITLE = "com.example.testapp.TITLE"
const val EXTRA_LIST = "com.example.testapp.LIST"
class NewList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_list)
    }

    fun saveNewList(view: View) {
        val titleText = findViewById<EditText>(R.id.new_list_title)
        val listText = findViewById<EditText>(R.id.list_items)
        val title = titleText.text.toString()
        val listItems = listText.text.toString()
        val intent = Intent()
        intent.putExtra(EXTRA_TITLE, title)
        intent.putExtra(EXTRA_LIST, listItems)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
