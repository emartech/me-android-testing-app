package com.example.mobile_engage.testing

import android.app.Application
import android.widget.Toast
import android.content.Context
import android.util.Log
import com.emarsys.Emarsys
import com.emarsys.config.EmarsysConfig
import com.emarsys.core.api.result.CompletionListener
import com.emarsys.mobileengage.api.EventHandler
import com.emarsys.mobileengage.api.NotificationEventHandler

import org.json.JSONObject

class TestingApplication: Application(), EventHandler, NotificationEventHandler,  CompletionListener {

    private val appCode = "EMSDB-1E315"
    private val customEventName = "test"
    private val contactFieldId = 3
    private val logTag = "me.testing"

    override fun onCreate() {
        super.onCreate()
        val config = EmarsysConfig.Builder()
            .application(this)
            .mobileEngageApplicationCode(appCode)
            .inAppEventHandler(this)
            .notificationEventHandler(this)
            .contactFieldId(contactFieldId)
            .build()

        Emarsys.setup(config)
        Emarsys.trackCustomEvent(customEventName, null)
        Emarsys.trackCustomEvent(customEventName, null)
    }

    override fun onCompleted(errorCause: Throwable?) {
        Log.i(logTag, "onCompleted")
        if (errorCause != null) {
            Toast.makeText(this, errorCause.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun handleEvent(eventName: String?, payload: JSONObject?) {
        Toast.makeText(this, eventName + " - " + payload.toString(), Toast.LENGTH_LONG).show()
    }

    override fun handleEvent(context: Context?, eventName: String?, payload: JSONObject?) {
        Toast.makeText(this, eventName + " - " + payload.toString(), Toast.LENGTH_LONG).show()
    }
}