package com.projects.sebdeveloper6952.examples.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Binder
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.ContextCompat
import com.projects.sebdeveloper6952.examples.toast

class OdometerService : Service() {

    private val binder = ServiceBinder()
    private lateinit var locationListener: LocationListener
    private lateinit var locationManager: LocationManager
    private var lastLocation: Location? = null
    private var distance = 0.0F

    override fun onCreate() {
        super.onCreate()
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationListener = createLocationListener()
        val provider = locationManager.getBestProvider(Criteria(), true)

        // check for fine location permission enabled
        if(ContextCompat.checkSelfPermission(this@OdometerService,
                android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(
                    provider,
                    1_000,
                    1F,
                    locationListener
            )
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    /**
     * Returns traveled distance.
     */
    fun getDistance() = distance

    /**
     * Creates a location listener object.
     * We only override one method for testing.
     */
    private fun createLocationListener(): LocationListener {
        return object: LocationListener {
            override fun onLocationChanged(location: Location?) {
                if(lastLocation == null) lastLocation = location
                val d = location?.distanceTo(lastLocation)
                distance  += d ?: 0F
                lastLocation = location
            }
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String?) {}
            override fun onProviderDisabled(provider: String?) {}

        }
    }

    inner class ServiceBinder: Binder() {
        fun getService(): OdometerService {
            return this@OdometerService
        }
    }
}
