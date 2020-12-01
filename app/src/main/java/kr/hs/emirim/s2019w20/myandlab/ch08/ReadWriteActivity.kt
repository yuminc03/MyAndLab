package kr.hs.emirim.s2019w20.myandlab.ch08

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kr.hs.emirim.s2019w20.myandlab.R
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Exception

class ReadWriteActivity : AppCompatActivity(){
    var TAG = "읽고쓰기액티비티"
    var FILENAME = "file.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_write)

        findViewById<Button>(R.id.btnWrite).setOnClickListener{
            try{
                var outFs = openFileOutput(FILENAME, Context.MODE_PRIVATE)
                var str = "Hello 쿡북 안드로이드"
                outFs.write(str.toByteArray())
                outFs.close()
                Log.e(TAG, "저장이 잘 되었어요!")
                Toast.makeText(this@ReadWriteActivity, FILENAME + "가 생성됨!", Toast.LENGTH_SHORT).show()

            }catch(e : Exception){
                Log.e(TAG, "뭔가 에러가?!")
            }

        }
        findViewById<Button>(R.id.btnRead).setOnClickListener{
            Toast.makeText(applicationContext, "버튼클릭!", Toast.LENGTH_SHORT).show()
            try{
                var inFs = openFileInput(FILENAME)
                var txt = ByteArray(30)
                inFs.read(txt)
                val str = txt.toString(Charsets.UTF_8)
                Toast.makeText(this@ReadWriteActivity, str, Toast.LENGTH_SHORT).show()
                inFs.close()
                Log.e(TAG, "읽기가 잘 되었어요!" + str)
                Toast.makeText(this, "끝!!", Toast.LENGTH_SHORT).show()
            }catch(e:IOException){
                Log.e(TAG, "파일 입출력 예외 발생!!")
                Toast.makeText(applicationContext, "파일을 읽을 수 없어요!", Toast.LENGTH_SHORT).show()
            }catch(e:Exception){
                Log.e(TAG, "뭔가 알 수 없는 예외 발생!")
            }
        }
    }
}