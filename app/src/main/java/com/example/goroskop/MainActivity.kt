package com.example.goroskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnStartClick(view: View) {
        var tree : String = ""
        if(etDate.text.toString() == "1")
            tree = "яблоня"
        var intent : Intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("tree", tree)
        startActivity(intent)
    }
}