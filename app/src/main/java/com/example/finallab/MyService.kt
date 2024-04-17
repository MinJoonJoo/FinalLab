package com.example.finallab
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {
    private val serviceScope = CoroutineScope(Dispatchers.Main)

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val countdownTime = intent.getIntExtra("countdown_value", 0)
        startCountdown(countdownTime)
        return START_NOT_STICKY
    }

    private fun startCountdown(time: Int) {
        serviceScope.launch {
            for (i in time downTo 1) {
                Log.i("MyService", "Countdown: $i")
                delay(1000)
            }
            Log.i("MyService", "Countdown finished")
            stopSelf()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}
