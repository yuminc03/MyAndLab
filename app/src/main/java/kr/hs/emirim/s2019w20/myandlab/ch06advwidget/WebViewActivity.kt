package kr.hs.emirim.s2019w20.myandlab.ch06advwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kr.hs.emirim.s2019w20.myandlab.R

class WebViewActivity : AppCompatActivity() {

    lateinit var etUrl : EditText
    lateinit var btnGo : Button
    lateinit var btnBack : Button
    lateinit var web : WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        etUrl = findViewById(R.id.etUrl)
        btnGo = findViewById(R.id.btnGo)
        btnBack = findViewById(R.id.btnBack)
        web = findViewById(R.id.webView1)

        web.webViewClient = CookWebViewClient()

        var webSet : WebSettings = web.settings
        webSet.builtInZoomControls = true //확대, 축소 가능

        btnGo.setOnClickListener{
            //web.loadUrl("http://google.co.kr")
            web.loadUrl(etUrl.text.toString())
            Toast.makeText(applicationContext, "URL은 " + etUrl.text.toString(), Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            web.goBack()
        }
    }
    class CookWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}