package kr.hs.emirim.s2019w20.myandlab.ch07menu

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.Menu
import android.view.MenuItem
import android.view.SubMenu
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kr.hs.emirim.s2019w20.myandlab.R

class OptionMenuActivity : AppCompatActivity() {

    lateinit var baseLayout : ConstraintLayout
    lateinit var btnThis : Button
    lateinit var vibrator : Vibrator

    enum class ITEM(val id:Int, title:String){
        RED(1, "배경색(빨강)"),
        GREEN(2, "배경색(초록)"),
        BLUE(3, "배경색(파랑)"),
        ROTATE(4, "45도 회전하기"),
        SIZEUP(5, "2배 키우기")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu)
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        initFindViewById()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        //var mInflater = menuInflater
        //mInflater.inflate(R.menu.menu1, menu)
        menu!!.add(0, ITEM.RED.id, 0, ITEM.RED.name)
        menu!!.add(0, ITEM.GREEN.id, 0, ITEM.GREEN.name)
        menu!!.add(0, ITEM.BLUE.id, 0, ITEM.BLUE.name)
        var sMenu : SubMenu = menu.addSubMenu("버튼 변경 >>")
        sMenu!!.add(0, ITEM.ROTATE.id, 0, ITEM.ROTATE.name)
        sMenu!!.add(0, ITEM.SIZEUP.id, 0, ITEM.SIZEUP.name)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {//무엇이 선택됬는지 찾는다
        super.onOptionsItemSelected(item)
        vibrator.vibrate(1000)
        vibrator.vibrate(longArrayOf(300, 200, 300, 300, 200, 300, 500), -1)

        when(item.itemId){
            ITEM.RED.id ->{
                baseLayout.setBackgroundColor(Color.RED)
            }
            ITEM.GREEN.id ->{
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            ITEM.BLUE.id ->{
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            ITEM.ROTATE.id ->{
                btnThis.rotation = btnThis.rotation + 45f
                return true
            }
            ITEM.SIZEUP.id ->{
                btnThis.scaleX = btnThis.scaleX + 2f
                return true
            }
        }
        return false
    }

    private fun initFindViewById() {
        baseLayout = findViewById(R.id.baseLayout)
        btnThis = findViewById(R.id.btnThis)
    }
}