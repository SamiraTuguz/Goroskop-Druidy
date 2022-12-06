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
    lateinit var calendar : Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Goroskop)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(getString(R.string.app_name))

        when (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_NO -> back.background = getDrawable(R.color.back)
            Configuration.UI_MODE_NIGHT_YES -> back.background = getDrawable(R.color.black)
        }

        calendarView.setOnDateChangeListener { view, year, month , dayOfMonth ->
            calendar = GregorianCalendar(year,month + 1,dayOfMonth)
        }
    }

    fun btnStartClick(view: View) {
        try{
            var bornDay = calendar.get(Calendar.DAY_OF_MONTH)
            var bornMonth = calendar.get(Calendar.MONTH)

            //декабрь == 0

            if(bornDay >= 23 && bornMonth == 0
                || bornDay <= 1  && bornMonth == 1
                || bornDay >= 25 && bornMonth == 6
                || bornDay <= 4 && bornMonth == 7)
                tree = "яблоня"
            else if(bornDay >= 2 && bornMonth == 1
                || bornDay <= 11  && bornMonth == 1
                || bornDay >= 5 && bornMonth == 7
                || bornDay <= 14 && bornMonth == 7)
                tree = "пихта"
            else if(bornDay >= 12 && bornMonth == 1
                || bornDay <= 24  && bornMonth == 1
                || bornDay >= 15 && bornMonth == 7
                || bornDay <= 25 && bornMonth == 7)
                tree = "вяз"
            else if(bornDay >= 25 && bornMonth == 1
                || bornDay <= 3  && bornMonth == 2
                || bornDay >= 26 && bornMonth == 7
                || bornDay <= 4 && bornMonth == 8)
                tree = "кипарис"
            else if(bornDay >= 4 && bornMonth == 2
                || bornDay <= 8  && bornMonth == 2
                || bornDay >= 5 && bornMonth == 8
                || bornDay <= 13 && bornMonth == 8)
                tree = "тополь"

            else if(bornDay >= 19 && bornMonth == 2
                || bornDay <= 28  && bornMonth == 2
                || bornDay >= 24 && bornMonth == 8
                || bornDay <= 2 && bornMonth == 9)
                tree = "сосна"
            else if(bornDay >= 1 && bornMonth == 3
                || bornDay <= 10  && bornMonth == 3
                || bornDay >= 3 && bornMonth == 9
                || bornDay <= 12 && bornMonth == 9)
                tree = "ива"
            else if(bornDay >= 11 && bornMonth == 3
                || bornDay <= 20  && bornMonth == 3
                || bornDay >= 13 && bornMonth == 9
                || bornDay <= 2225 && bornMonth == 9)
                tree = "липа"
            else if(bornDay >= 22 && bornMonth == 3
                || bornDay <= 31  && bornMonth == 3
                || bornDay >= 24 && bornMonth == 9
                || bornDay <= 3 && bornMonth == 10)
                tree = "орешник"
            else if(bornDay >= 1 && bornMonth == 4
                || bornDay <= 10  && bornMonth == 4
                || bornDay >= 4 && bornMonth == 10
                || bornDay <= 13 && bornMonth == 10)
                tree = "рябина"
            else if(bornDay >= 11 && bornMonth == 4
                || bornDay <= 20  && bornMonth == 4
                || bornDay >= 14 && bornMonth == 10
                || bornDay <= 23 && bornMonth == 10)
                tree = "клен"
            else if(bornDay >= 21 && bornMonth == 4
                || bornDay <= 30  && bornMonth == 4
                || bornDay >= 24 && bornMonth == 10
                || bornDay <= 2 && bornMonth == 11)
                tree = "орех"
            else if(bornDay >= 1 && bornMonth == 5
                || bornDay <= 14  && bornMonth == 5
                || bornDay >= 3 && bornMonth == 11
                || bornDay <= 11 && bornMonth == 11)
                tree = "жасмин"
            else if(bornDay >= 15 && bornMonth == 5
                || bornDay <= 24  && bornMonth == 5
                || bornDay >= 12 && bornMonth == 11
                || bornDay <= 21 && bornMonth == 11)
                tree = "каштан"
            else if(bornDay >= 23 && bornMonth == 5
                || bornDay <= 3  && bornMonth == 6
                || bornDay >= 22 && bornMonth == 11
                || bornDay <= 1 && bornMonth == 0)
                tree = "ясень"
            else if(bornDay >= 4 && bornMonth == 6
                || bornDay <= 13  && bornMonth == 6
                || bornDay >= 2 && bornMonth == 0
                || bornDay <= 11 && bornMonth == 0)
                tree = "граб"
            else if(bornDay >= 14 && bornMonth == 6
                || bornDay <= 23  && bornMonth == 6
                || bornDay >= 12 && bornMonth == 0
                || bornDay <= 21 && bornMonth == 0)
                tree = "инжир"
            else if(bornDay == 21 && bornMonth == 3)
                tree = "дуб"
            else if(bornDay == 24 && bornMonth == 6)
                tree = "береза"
            else if(bornDay == 23 && bornMonth == 9)
                tree = "маслина"
            else if(bornDay >= 21 && bornMonth == 0
                || bornDay <= 22  && bornMonth == 0)
                tree = "бук"
            else if(bornDay >= 9 && bornMonth == 2
                || bornDay <= 18  && bornMonth == 2
                || bornDay >= 14 && bornMonth == 8
                || bornDay <= 23 && bornMonth == 8)
                tree = "кедр"

            var intent : Intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("tree", tree)
            startActivity(intent)
            finish()
        }
        catch (e : java.lang.Exception){
            Toast.makeText(this,"Ошибка", Toast.LENGTH_LONG).show()
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