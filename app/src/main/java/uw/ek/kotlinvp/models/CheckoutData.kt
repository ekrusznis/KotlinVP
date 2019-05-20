package uw.ek.kotlinvp.models

import android.content.Context

data class  CheckoutData(var context: Context){

   class checkoutCardName(cardName: String) {
       var _cardName: String = cardName
           get() = _cardName
           set(_cardName) {
               field = _cardName
           }
   }
    class checkoutCardNum(cardNumber: String){
        var _cardNumber: String = cardNumber
            set(_cardNumber) {
                field = _cardNumber
            }

    }
    class checkoutFoodItemName(foodItemName: String){
        var _foodItemName: String = foodItemName
            get() = _foodItemName
            set(_foodItemName) {
                field = _foodItemName
            }
    }
    class checkoutPrice(price: Int){
        var _price: Int = price
            get() = _price
            set(_price) {
                field = _price
            }


   }

}