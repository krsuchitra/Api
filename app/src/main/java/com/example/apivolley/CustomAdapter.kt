package com.example.apivolley


import android.app.LauncherActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray


lateinit var textView: TextView

class CustomAdapter(private val mList: List<LauncherActivity.ListItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, ViewType:Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design , parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.textView.text = ItemsViewModel.price
        holder.textView1.text =ItemsViewModel.rating
        holder.textView2.text =ItemsViewModel.text



        }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val textView: TextView = itemView.findViewById(R.id.price)
        val textView1: TextView = itemView.findViewById(R.id.rating)
        val textView2: TextView = itemView.findViewById(R.id.name)

    }


}


data class ItemsViewModel(val price: Int, val rating: Int,val text: String) {

}
