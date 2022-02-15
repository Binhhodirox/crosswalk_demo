package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.xwalk.core.*


class MainActivity : XWalkActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onXWalkReady() {
        val xWalkWebView = findViewById<View>(R.id.xwalkWebView) as XWalkView
        xWalkWebView.clearCache(true)


        xWalkWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            javaScriptCanOpenWindowsAutomatically = true
            loadsImagesAutomatically = true
            allowContentAccess = true


        }

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true)

        xWalkWebView.loadUrl("https://www.whatismybrowser.com/detect/ecma-script-version", null)
    }
}