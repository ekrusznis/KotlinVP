package uw.ek.kotlinvp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import uw.ek.kotlinvp.fragments.FoodFragment
import uw.ek.kotlinvp.fragments.CheckoutFragment
import uw.ek.kotlinvp.fragments.ConfirmationFragment

class FoodVPAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FoodFragment()
            }
            1 -> CheckoutFragment()
            else -> {
                return ConfirmationFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Food"
            1 -> "Checkout"
            else -> {
                return "Confirmation"
            }
        }
    }

}