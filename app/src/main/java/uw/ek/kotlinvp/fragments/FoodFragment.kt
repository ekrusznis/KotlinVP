package uw.ek.kotlinvp.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_food.*
import uw.ek.kotlinvp.models.FoodModel
import uw.ek.kotlinvp.R
import uw.ek.kotlinvp.adapters.FoodRVAdapter

class FoodFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Kotlin Example"

        val foodOptions = listOf(
            FoodModel(
                "#2 Jersey Shores Favorite",
                "Provolone, Ham, and Cappacuolo",
                ContextCompat.getDrawable(view.context, R.drawable.jersey_fav_reg)
            ),
            FoodModel(
                "#3 Ham and Provolone",
                "A true classic",
                ContextCompat.getDrawable(view.context, R.drawable.rbprov)
            ),
            FoodModel(
                "#14 The Veggie",
                "Swiss, Provolone, and Green Bell Peppers",
                ContextCompat.getDrawable(view.context, R.drawable.vegg)
            ),
            FoodModel(
                "#5 The Super Sub",
                "Provolone, Ham, Prosciuttini, and Cappacuolo",
                ContextCompat.getDrawable(view.context, R.drawable.tuna)
            ),
            FoodModel(
                "#10 Tuna Fish",
                "Freshly made on premises",
                ContextCompat.getDrawable(view.context, R.drawable.jersey_fav_reg)
            ),
            FoodModel(
                "#6 Roast Beef and Provolone",
                "Cooked on premises using USDA Choice top rounds!",
                ContextCompat.getDrawable(view.context, R.drawable.tuna)
            ),
            FoodModel(
                "#13 The Italian",
                "Provolone, Ham, Prosciuttini, Cappacuolo, Salami, and Pepporoni",
                ContextCompat.getDrawable(view.context, R.drawable.italian)
            ),
            FoodModel(
                "#8 Club Sub",
                "Turkey, Ham, Provolone, Applewood Smoked Bacon, and Mayo",
                ContextCompat.getDrawable(view.context, R.drawable.club)
            )
        )


        rv.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = FoodRVAdapter(foodOptions)
        }
    }


    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
    }
}
