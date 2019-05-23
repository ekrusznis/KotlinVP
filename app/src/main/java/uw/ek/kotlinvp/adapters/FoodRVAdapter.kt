package uw.ek.kotlinvp.adapters

import android.content.SharedPreferences
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import uw.ek.kotlinvp.models.FoodModel
import uw.ek.kotlinvp.R
import uw.ek.kotlinvp.utils.SharedPreference

class FoodRVAdapter(private val list: List<FoodModel>)
    : RecyclerView.Adapter<FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FoodViewHolder(inflater, parent)

    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodModel: FoodModel = list[position]
        holder.bind(foodModel)

    }

    override fun getItemCount(): Int = list.size

}

class FoodViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.single_food_item, parent, false)) {
    private var mTitleView: TextView
    private var mDescView: TextView
    private var mImageView: ImageView
    private val cardView: CardView
    private var foodCheck: CheckBox
    val sharedPreference: SharedPreference = SharedPreference(parent.context)
    val editor: SharedPreferences.Editor = sharedPreference.sharedPref.edit()
    val TAG: String = "FoodRVAdapter"

    val tabLay: TabLayout? = parent.findViewById(R.id.tabs_main)
    val viewp: ViewPager? = parent.findViewById(R.id.customVP)

    init {
        mTitleView = itemView.findViewById(R.id.title)
        mDescView = itemView.findViewById(R.id.description)
        mImageView = itemView.findViewById(R.id.image)
        foodCheck = itemView.findViewById(R.id.foodCheck)
        cardView = itemView.findViewById(R.id.cvFood)

        cardView.setOnClickListener(View.OnClickListener {
            Log.i(TAG, sharedPreference.sharedPref.all.toString())
            if (foodCheck.isChecked){
                foodCheck.isChecked= false
                sharedPreference.sharedPref.getString("title", mTitleView.text.toString())
                editor.remove(mTitleView.text.toString());
                editor.apply();
                Log.i(TAG, sharedPreference.sharedPref.all.toString())

            }else{
                foodCheck.isChecked= true
                val t = Toast.makeText(parent.context,  "You chose " + mTitleView.text.toString(), Toast.LENGTH_LONG)
                t. show()
                Log.i(TAG, sharedPreference.sharedPref.all.toString())
                tabLay?.getTabAt(2)?.select();
                viewp?.setCurrentItem(2)

            }

        })
    }

    fun bind(foodModel: FoodModel) {
        mTitleView.text = foodModel.title
        mDescView.text = foodModel.descrip
        mImageView.background = foodModel.image

    }


}

