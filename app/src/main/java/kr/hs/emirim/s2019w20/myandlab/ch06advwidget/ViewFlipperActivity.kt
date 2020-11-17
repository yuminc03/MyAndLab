package kr.hs.emirim.s2019w20.myandlab.ch06advwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.constraintlayout.widget.ConstraintLayout
import kr.hs.emirim.s2019w20.myandlab.R

class ViewFlipperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)

        val vFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        findViewById<ImageView>(R.id.btnLeft).setOnClickListener {
            vFlipper.showPrevious()
        }

        findViewById<ImageView>(R.id.btnRight).setOnClickListener {
            vFlipper.showNext()
        }

        findViewById<ConstraintLayout>(R.id.bg).setOnClickListener {
            if(!vFlipper.isAutoStart){
                vFlipper.stopFlipping()
            }else{
                vFlipper.startFlipping()
            }
        }
    }
}