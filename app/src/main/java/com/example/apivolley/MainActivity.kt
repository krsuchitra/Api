package com.example.apivolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException


class MainActivity(val jsonArray: List<ItemsViewModel>) : AppCompatActivity() {

    private var requestQueue: RequestQueue?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)
         jsonParse()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ItemsViewModel>()

        for (i in 1..200) {
            data.add(ItemsViewModel(R.drawable.ic_baseline_folder_24,4,"CLANLANDS"))
        }
        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter
    }




    private fun jsonParse() {
        val url ="http://128.199.23.215:8083/mobikulhttp/shop?eTag=&storeId=1&currency=INR&locale=en&search=&page=1&limit=10&price=0%2C999999&sort=created_at&order=desc"
        val request = JsonObjectRequest(Request.Method.GET, url, null,Response.Listener { response ->
            try {
            val jsonArray = response.getJSONArray("productList")

            for (i in 0 until jsonArray.length()) {

                val productList = jsonArray.getJSONObject(i)
                val name = productList.getString("")
                textView.append("$name \n\n")
            }

            } catch (e: JSONException) {
                e.printStackTrace()
            }


        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)

    }


    private fun CustomAdapter(jsonArray: List<ItemsViewModel>): CustomAdapter {
        val customAdapter:CustomAdapter =CustomAdapter(jsonArray)
         return  jsonArray
    }

}


