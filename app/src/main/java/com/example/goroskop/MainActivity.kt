package com.example.goroskop

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {
    var tree : String = ""
    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Goroskop)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(getString(R.string.app_name))

        when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_NO -> back.background = getDrawable(R.color.back)
            Configuration.UI_MODE_NIGHT_YES -> back.background = getDrawable(R.color.black)
        }

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            text = "$dayOfMonth.${month + 1}.$year"
        }
    }

    fun btnStartClick(view: View) {
        try{
            val sdf = SimpleDateFormat("DD.MM.yyyy")

            val firstDate: Date = sdf.parse(text)
            val secondDate: Date = sdf.parse("06.09.2022")


            Toast.makeText(this, firstDate.after(secondDate).toString(), Toast.LENGTH_LONG).show()
            if(firstDate.before(sdf.parse("05.10.2022")) && firstDate.after(secondDate))
                tree = "яблоня"
            else if(firstDate.after(sdf.parse("06.10.2005")) || firstDate.before(sdf.parse("05.11.2005")))
                tree = "кипарис"




            var intent : Intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("tree", tree)
            startActivity(intent)
        }
        catch (e : java.lang.Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.darkTheme -> {
                back.background = getDrawable(R.color.black)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            R.id.lightTheme -> {
                back.background = getDrawable(R.color.back)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}