package uw.ek.kotlinvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.vinaygaba.creditcardview.CreditCardView
import kotlinx.android.synthetic.main.fragment_checkout.*
import uw.ek.kotlinvp.R
import uw.ek.kotlinvp.SharedPreference
import uw.ek.kotlinvp.models.CheckoutData

class CheckoutFragment : Fragment(),AdapterView.OnItemSelectedListener {
    var qtyList = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_checkout, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val sharedPreference: SharedPreference = SharedPreference(view.context)
            val TAG: String = "CheckoutFragment"

            val creditCardView : CreditCardView = view.findViewById(R.id.ccv)
            val confirmButton: Button= view.findViewById(R.id.confirmButton)
            val subname : TextView = view.findViewById(R.id.subname)
            val subdesc : TextView = view.findViewById(R.id.subdesc)

            subname.text = sharedPreference.sharedPref.getString("title", "Super Sub")
            subdesc.text = sharedPreference.sharedPref.getString("description", "description")

            confirmButton.setOnClickListener(View.OnClickListener {
                CheckoutData.Data.cardName = creditCardView.cardName
                CheckoutData.Data.cardNum = creditCardView.cardNumber
                CheckoutData.Data.foodPrice = 5.99
                CheckoutData.Data.foodName = subname.text.toString()

            })

            qtySpinner?.setOnItemSelectedListener(this)
            val aa = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, qtyList)
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            qtySpinner?.setAdapter(aa)

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}