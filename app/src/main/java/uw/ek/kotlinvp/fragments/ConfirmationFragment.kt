package uw.ek.kotlinvp.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import uw.ek.kotlinvp.R
import uw.ek.kotlinvp.models.CheckoutData

class ConfirmationFragment : Fragment(), View.OnClickListener {
    var TAG : String = "ConfirmationFragment:"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Log.i(TAG, listOf(MainActivity.dataSet))

        val confButton: Button= view.findViewById(R.id.confButton)
        confButton.setOnClickListener(this)
        val confCardsNum : TextView = view.findViewById(R.id.confCardsNum)
        val confCardsName : TextView = view.findViewById(R.id.confCardsName)
        val confRemoveTV : TextView = view.findViewById(R.id.confRemoveTV)
        confRemoveTV.setOnClickListener(this)
        val confPricing : TextView = view.findViewById(R.id.confPricing)
        confPricing.text = CheckoutData.Data.foodPrice.toString()
        val confDescription : TextView = view.findViewById(R.id.confDescription)
        val confFoodTitle : TextView = view.findViewById(R.id.confFoodTitle)
        confFoodTitle.text = CheckoutData.Data.foodName
        val confFoodImage : ImageView = view.findViewById(R.id.confFoodImage)

        val confTotalPrice: TextView = view.findViewById(R.id.confTotalPrice)
        confTotalPrice.text = confPricing.text.toString()
        if(CheckoutData.Data.cardName.equals("")){
            confCardsName.text = "John Hancock"
        }else{ confCardsName.text = CheckoutData.Data.cardName        }
        if(CheckoutData.Data.cardName.equals("")){
            confCardsNum.text = "1234 5678 5555"
        }else{confCardsNum.text = CheckoutData.Data.cardNum }
        if(CheckoutData.Data.foodName.equals("")){
            confFoodTitle.text = "#9 Super Sub"
        }else{confFoodTitle.text = CheckoutData.Data.foodName }
        if(CheckoutData.Data.foodPrice.equals("")){
            confPricing.text = "5.99"
        }else{confPricing.text = CheckoutData.Data.foodPrice.toString() }

    }


    override fun onClick(v: View?) {
        val item_id = v?.id
        when (item_id) {
            R.id.confButton-> runDialog(v.context)

        }

    }

    fun runDialog(cx: Context) {
        Log.i("runDialog", "here")
        val dialogBuilder = AlertDialog.Builder(cx)
        dialogBuilder.setMessage("Thank you for your purchase, your order should be ready soon!")
            .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialog, id -> dialog.dismiss()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Completed")
        alert.show()

    }
}