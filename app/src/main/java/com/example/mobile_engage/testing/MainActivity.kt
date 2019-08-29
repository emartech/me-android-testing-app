package com.example.mobile_engage.testing

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emarsys.core.api.result.CompletionListener
import com.emarsys.Emarsys

class MainActivity : AppCompatActivity(), CompletionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        sendLatencyTestEvents()
    }

    override fun onCompleted(errorCause: Throwable?) {
        if(errorCause == null) setStatus(R.string.done_label)
        else {
            setStatus(R.string.error_label)
            Toast.makeText(this, errorCause.message, Toast.LENGTH_LONG).show()
        }
    }

    private fun sendLatencyTestEvents() {
        val customEventName = "latency-test"

        setStatus(R.string.in_progress_label)
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null, this)
    }

    private fun setStatus(resId: Int) {
        val statusTextView: TextView = findViewById(R.id.statusTextView)
        statusTextView.setText(resId)
    }
}
