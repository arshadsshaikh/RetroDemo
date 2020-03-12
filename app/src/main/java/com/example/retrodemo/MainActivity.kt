package com.example.retrodemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var  apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        apiInterface=ApiClient.getAPIClient().create(ApiInterface::class.java)

        val call: Call<DemoModel?>? = apiInterface.doGetListResources()



        call?.enqueue(object : Callback<DemoModel?>{

            override fun onFailure(call: Call<DemoModel?>, t: Throwable) {

                Toast.makeText(this@MainActivity,"get response",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<DemoModel?>, response: Response<DemoModel?>) {
                Toast.makeText(this@MainActivity,"get response"+response.body(),Toast.LENGTH_SHORT).show()

                val model=response.body()
            }


        })

    }
}
