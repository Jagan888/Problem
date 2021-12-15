package com.example.food_ordering_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DeleteConfirmationActivity : AppCompatActivity() {
    lateinit var session:SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_confirmation)

        session=SessionManager(this)



        val dbutton = findViewById<Button>(R.id.button6)

        dbutton.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            val apiClient = application as ApiClient
            var token=session.fetchAuthToken()
            withContext(Dispatchers.Main) {
                var result = apiClient.apiService.delete(
                    "Bearer"+token

                    )


            }

        }
    }
    }

}