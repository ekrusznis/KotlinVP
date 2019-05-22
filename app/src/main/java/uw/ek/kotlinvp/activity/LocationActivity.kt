package uw.ek.kotlinvp.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import uw.ek.kotlinvp.BuildConfig
import uw.ek.kotlinvp.R

class LocationActivity : AppCompatActivity(), OnMapReadyCallback{
    val REQUEST_PERMISSIONS_REQUEST_CODE : Int = 123
    private var mFusedLocationClient: FusedLocationProviderClient? = null
    protected var mLastLocation: Location? = null
    private var mLatitudeText: TextView? = null
    private var mLongitudeText: TextView? = null
    private lateinit var mMap: GoogleMap
    val ZOOM_LEVEL = 18f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val mapFragment : SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        mLatitudeText = findViewById<View>(R.id.latitude_textview) as TextView?
        mLongitudeText = findViewById<View>(R.id.longitude_textview) as TextView?
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    public override fun onStart() {
        super.onStart()
//        mapView!!.onStart()
        if (!checkPermissions()) {
            requestPermissions()
        } else {
//            getLastLocation()
        }


    }

    override fun onMapReady(googleMap: GoogleMap?) {
        getLastLocation(googleMap)
    }


    private fun getLastLocation(googleMap: GoogleMap?) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            || ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mFusedLocationClient!!.lastLocation
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful && task.result != null) {
                        mLastLocation = task.result

                        mLatitudeText!!.text = mLastLocation?.latitude.toString()
                        Log.i("LAT", mLastLocation?.latitude.toString())
                        mLongitudeText!!.text = mLastLocation?.longitude.toString()
                        Log.i("LONG", mLastLocation?.longitude.toString())
                        val sydney = LatLng(mLastLocation!!.latitude, mLastLocation!!.longitude)

                        with(googleMap) {
                            this?.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(sydney, ZOOM_LEVEL))
                            this?.addMarker(com.google.android.gms.maps.model.MarkerOptions().position(sydney))
                        }


                    } else {
                        Log.w(TAG, "getLastLocation:exception", task.exception)
                        showMessage(getString(R.string.no_location_detected))
                    }
                }
        }
    }

    private fun showMessage(text: String) {
        val container = findViewById<View>(R.id.main_activity_container)
        if (container != null) {
            Toast.makeText(this@LocationActivity, text, Toast.LENGTH_LONG).show()
        }
    }

    private fun showSnackbar(mainTextStringId: Int, actionStringId: Int,
                             listener: View.OnClickListener) {

        Toast.makeText(this@LocationActivity, getString(mainTextStringId), Toast.LENGTH_LONG).show()
    }

private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this@LocationActivity,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
            REQUEST_PERMISSIONS_REQUEST_CODE)
    }

    private fun requestPermissions() {
        val shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(this,
            Manifest.permission.ACCESS_COARSE_LOCATION)

        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.")

            showSnackbar(
                R.string.permission_rationale, android.R.string.ok,
                View.OnClickListener {
                    // Request permission
                    startLocationPermissionRequest()
                })

        } else {
            Log.i(TAG, "Requesting permission")
            startLocationPermissionRequest()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        Log.i(TAG, "onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) {

                Log.i(TAG, "User interaction was cancelled.")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getLastLocation()
            } else {

                showSnackbar(
                    R.string.permission_denied_explanation, R.string.settings,
                    View.OnClickListener {
                        // Build intent that displays the App settings screen.
                        val intent = Intent()
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        val uri = Uri.fromParts("package",
                            BuildConfig.APPLICATION_ID, null)
                        intent.data = uri
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                    })
            }
        }
    }

    companion object {

        private val TAG = "LocationProvider"

        private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    }


    override fun onResume() {
        super.onResume()

    }
    override fun onPause() {
        super.onPause()
    }
    override fun onStop() {
        super.onStop()

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
    override fun onLowMemory() {
        super.onLowMemory()

    }
    override fun onDestroy() {
        super.onDestroy()
    }

}