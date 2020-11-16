package kr.hs.emirim.s2019w20.myandlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kr.hs.emirim.s2019w20.myandlab.ch04widget.BasicWidgetActivity
import kr.hs.emirim.s2019w20.myandlab.ch04widget.CalActivity
import kr.hs.emirim.s2019w20.myandlab.ch04widget.LovelyPetActivity
import kr.hs.emirim.s2019w20.myandlab.ch04widget.RotateImageActivity
import kr.hs.emirim.s2019w20.myandlab.ch05layout.NoXmlActivity
import kr.hs.emirim.s2019w20.myandlab.ch06advwidget.DateTimeBookActivity
import kr.hs.emirim.s2019w20.myandlab.ch06advwidget.ViewFlipperActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent : Intent? = null
        when(v.id){
            R.id.button1 -> intent = Intent(this, FourbuttonActivity::class.java)
            R.id.button2 -> intent = Intent(this, Fourbutton2Activity::class.java)
            R.id.button3 -> intent = Intent(this, CalActivity::class.java)
            R.id.button4 -> intent = Intent(this, BasicWidgetActivity::class.java)
            R.id.button5 -> intent = Intent(this, LovelyPetActivity::class.java)
            R.id.button6 -> intent = Intent(this, RotateImageActivity::class.java)
            R.id.button7 -> intent = Intent(this, NoXmlActivity::class.java)
            R.id.button8 -> intent = Intent(this, DateTimeBookActivity::class.java)
            R.id.button9 -> intent = Intent(this, ViewFlipperActivity::class.java)
            else -> return
        }
        startActivity(intent)
    }
}
