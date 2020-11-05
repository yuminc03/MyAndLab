package kr.hs.emirim.s2019w20.myandlab.ch04widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kr.hs.emirim.s2019w20.myandlab.R
import kr.hs.emirim.s2019w20.myandlab.R.drawable

class LovelyPetActivity : AppCompatActivity() {

    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoDog : RadioButton
    lateinit var rdoCat : RadioButton
    lateinit var rdoRabbit : RadioButton
    lateinit var btnOk : Button
    lateinit var imgPet : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lovely_pet)

        title = "애완 동물 사진 보기"

        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)
        chkAgree = findViewById(R.id.cbStart)
        rGroup1 = findViewById(R.id.radioGroup2)
        rdoDog = findViewById(R.id.rbDog)
        rdoCat = findViewById(R.id.rbCat)
        rdoRabbit = findViewById(R.id.rbRabbit)
        btnOk = findViewById(R.id.btnSelect)
        imgPet = findViewById(R.id.ImgPet)

        chkAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOk.visibility = android.view.View.VISIBLE
                imgPet.visibility = android.view.View.VISIBLE
            }else{
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOk.visibility = android.view.View.INVISIBLE
                imgPet.visibility = android.view.View.INVISIBLE
            }
        }
        btnOk.setOnClickListener{
            when(rGroup1.checkedRadioButtonId){
                R.id.rbDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.rbCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.rbRabbit -> imgPet.setImageResource(R.drawable.rabbit)
                else -> Toast.makeText(applicationContext,
                "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show()
            }
        }

    }
}