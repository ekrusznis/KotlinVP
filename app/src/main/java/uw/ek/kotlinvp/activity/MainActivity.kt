package uw.ek.kotlinvp.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import uw.ek.kotlinvp.R
import uw.ek.kotlinvp.adapters.FoodVPAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = FoodVPAdapter(supportFragmentManager)
        customVP.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(customVP)

        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        val locIntnt = Intent(this, LocationActivity::class.java)
        val loginIntnt = Intent(this, LoginActivity::class.java)
        val prefsIntnt = Intent(this, SettingsActivity::class.java)

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_location -> startActivity(locIntnt)
                R.id.action_viewpager -> startActivity(loginIntnt)
                R.id.action_prefs ->  startActivity(prefsIntnt)
                R.id.action_new -> {
//                    toast("Snackbar message")
                    showMessage(navigation_view,"Snackbar message example...")

                }

            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
    fun showMessage(view:View, message: String){
        Snackbar
            .make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null)
            .setActionTextColor(resources.getColor(R.color.colorPrimary))
            .show()
    }

}

