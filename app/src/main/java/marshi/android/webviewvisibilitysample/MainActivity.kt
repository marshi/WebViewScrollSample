package marshi.android.webviewvisibilitysample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview = findViewById<WebView>(R.id.webview)
        webview.visibility = View.GONE
        webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webview.visibility = View.VISIBLE
            }
        }
        val setting = webview.settings
        setting.javaScriptEnabled = true
        setting.allowUniversalAccessFromFileURLs = true
        webview.loadUrl("https://raw.githubusercontent.com/marshi/WebViewScrollSample/master/sample.html")
    }
}
