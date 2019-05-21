package uw.ek.kotlinvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.vinaygaba.creditcardview.CreditCardView
import kotlinx.android.synthetic.main.fragment_checkout.*
import org.w3c.dom.Text
import uw.ek.kotlinvp.MainActivity
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

    }


}