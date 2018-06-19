package com.projects.sebdeveloper6952.examples.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.view.View
import com.projects.sebdeveloper6952.examples.R
import com.projects.sebdeveloper6952.examples.services.OdometerService
import com.projects.sebdeveloper6952.examples.toast
import kotlinx.android.synthetic.main.activity_test_service.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TestServiceActivity : AppCompatActivity() {

    private var _service: OdometerService? = null
    private var bound = false

    private val serviceConn = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            toast("onServiceConnected()")
            val binder = service as OdometerService.ServiceBinder
            _service = binder.getService()
            bound = true
            updateDistance()
        }
        override fun onServiceDisconnected(name: ComponentName?) {
            toast("onServiceDisconnected()")
            bound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_service)

        val intent = Intent(this@TestServiceActivity, OdometerService::class.java)

        bindService(intent, serviceConn, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindFromService()
    }

    fun btnUnbound(v: View) {
        unbindFromService()
    }

    private fun unbindFromService() {
        if(bound) {
            unbindService(serviceConn)
            bound = false
        }
    }

    private fun updateDistance() {
        textView.text = _service?.getDistance().toString()
        Handler().postDelayed({
            updateDistance()
        }, 1_000)
    }
}
