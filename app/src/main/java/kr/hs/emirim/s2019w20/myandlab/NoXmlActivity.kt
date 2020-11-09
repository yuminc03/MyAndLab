package kr.hs.emirim.s2019w20.myandlab

import android.graphics.Color
import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class NoXmlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_xml2)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val baseLayout = LinearLayout(this)
        baseLayout.orientation=LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0))
        setContentView(baseLayout, params)

        var btn = Button(this)
        btn.text = "버튼입니다"
        btn.setBackgroundColor(Color.MAGENTA)
        baseLayout.addView(btn)

        btn.setOnClickListener{
            Toast.makeText(applicationContext, "코드로 생성한 버튼입니다. ",
            Toast.LENGTH_SHORT).show()
        }
    }
}