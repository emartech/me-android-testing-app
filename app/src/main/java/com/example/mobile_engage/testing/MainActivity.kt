package com.example.mobile_engage.testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emarsys.Emarsys

class MainActivity : AppCompatActivity() {

    private val customEventName = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        sendCustomEvents()
    }

    private fun sendCustomEvents() {
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null)
    }
}
