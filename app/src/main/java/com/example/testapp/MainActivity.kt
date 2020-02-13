package com.example.testapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

const val SAVED_LIST_DATA = "com.android.testapp.DATA"
const val SAVED_LIST_TITLE = "com.android.testapp.TITLE"

val map = ConcurrentHashMap<String?, String?>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (map.isEmpty()) {
            return
        }
        else {
            for ((t, d) in map) {
                val layout = findViewById<LinearLayout>(R.id.linear_layout_lists)
                val textView = TextView(this)
                textView.text = t
                textView.textSize = 22.0F
                textView.setTextColor(Color.parseColor("black"))
                textView.setOnClickListener{

                    val intent = Intent(this, ViewList::class.java).apply {
                        putExtra(SAVED_LIST_DATA, d)
                        putExtra(SAVED_LIST_TITLE, t)
                    }
                    startActivity(intent)

                }
                layout.addView(textView)
            }
        }
    }

    fun addList(view: View) {
        val intent = Intent(this, NewList::class.java).apply {

        }
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                val layout = findViewById<LinearLayout>(R.id.linear_layout_lists)
                val listTitle = data?.getStringExtra(EXTRA_TITLE)
                val listData = data?.getStringExtra(EXTRA_LIST)
                if (map[listTitle] !== null) {
                    map["$listTitle 1"] = listData
                }
                else {
                    map[listTitle] = listData
                }

                val textView = TextView(this)
                textView.text = listTitle
                textView.textSize = 22.0F
                textView.setTextColor(Color.parseColor("black"))
                textView.setOnClickListener{

                        val intent = Intent(this, ViewList::class.java).apply {
                            putExtra(SAVED_LIST_DATA, listData)
                            putExtra(SAVED_LIST_TITLE, listTitle)
                        }
                        startActivityForResult(intent, 2)
                }
                layout.addView(textView)

            }
        }
    }

}
