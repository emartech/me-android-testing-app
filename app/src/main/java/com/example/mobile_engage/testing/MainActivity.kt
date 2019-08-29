package com.example.mobile_engage.testing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emarsys.Emarsys

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        sendLatencyTestEvents()
    }

    private fun sendLatencyTestEvents() {
        val customEventName = "latency-test"
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null)
    }
}
