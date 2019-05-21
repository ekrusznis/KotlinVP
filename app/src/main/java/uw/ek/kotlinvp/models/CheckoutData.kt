package uw.ek.kotlinvp.models

import android.content.Context
import java.util.*

data class  CheckoutData(var context: Context){
        object Data{
            var cardName: String = ""
            var cardNum: String = ""
            var foodName: String = ""
            var foodPrice: Double = 0.00
    }

}