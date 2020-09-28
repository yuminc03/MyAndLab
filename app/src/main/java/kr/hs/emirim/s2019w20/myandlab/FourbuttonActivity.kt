package kr.hs.emirim.s2019w20.myandlab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FourbuttonActivity : AppCompatActivity(),  View.OnClickListener {

    private lateinit var mButton1 : Button
    private lateinit var mButton2 : Button
    private lateinit var mButton3 : Button
    private lateinit var mButton4 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourbutton)

        mButton1 = findViewById(R.id.button1)
        mButton2 = findViewById(R.id.button2)
        mButton3 = findViewById(R.id.button3)
        mButton4 = findViewById(R.id.button4)

        mButton1.setOnClickListener(this)//버튼이 많은 경우
        mButton2.setOnClickListener(this)
        mButton3.setOnClickListener(this)
        mButton4.setOnClickListener{//버튼이 적은 경우
            finish()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button1 -> {
                val intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/")
                )
                startActivity(intent)
            }
            R.id.button2 -> {
                val intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("tel:/911")
                )
                startActivity(intent)
            }
            R.id.button3 -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media")
                )
                startActivity(intent)
            }
            //R.id.button4 -> finish()
            else -> Toast.makeText(
                this, "잘못 누르셨습니다!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}