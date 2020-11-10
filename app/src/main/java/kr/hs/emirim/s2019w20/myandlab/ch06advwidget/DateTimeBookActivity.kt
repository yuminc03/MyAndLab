package kr.hs.emirim.s2019w20.myandlab.ch06advwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import kr.hs.emirim.s2019w20.myandlab.R
import org.w3c.dom.Text
import java.util.*

class DateTimeBookActivity : AppCompatActivity() {

    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var timePicker1: TimePicker
    lateinit var tvDatetime : TextView

    var selectYear : Int = 0
    var selelctMonth : Int = 0
    var selectDay : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_book)

        title="시간 예약"

        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        chrono = findViewById(R.id.choronometer1)
        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)
        timePicker1 = findViewById(R.id.timePicker1)
        calView = findViewById(R.id.calendarView1)
        tvDatetime = findViewById(R.id.tvDatetime)

        timePicker1.visibility = View.GONE
        calView.visibility = View.GONE

    }
}