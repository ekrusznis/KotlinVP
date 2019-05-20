package uw.ek.kotlinvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
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
//        val intent = Intent(this, ViewPagerActivity::class.java)

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
//                R.id.action_recyclerview -> toast("RV clicked")
//                R.id.action_viewpager -> startActivity(intent)
//                R.id.action_prefs -> toast("Prefs clicked")
//                R.id.action_new -> {
                // Multiline action
//                    toast("New clicked")
//                }

            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }
        class dataSet(){
        class setCardName(cardNameInput: String){
            var cardName: String = cardNameInput
                get() = field
        }
            class setCardNum(cardNumberInput: String){
                var cardNumber: String = cardNumberInput
           }

            class setFoodNameItem(foodItemNameInput: String){
                var foodItemName: String = foodItemNameInput
                    get() = field
            }
            class setPrice(priceInput: Int){
                var price: Int = priceInput
                    get() = field
            }


    }

}

