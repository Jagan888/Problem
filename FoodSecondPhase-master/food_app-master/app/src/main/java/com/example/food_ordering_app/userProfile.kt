package com.example.food_ordering_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class userProfile : AppCompatActivity() {
    lateinit var session:SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val userdelete = findViewById<Button>(R.id.button5)
        val updateemail=findViewById<Button>(R.id.changeEmail)
        val emailId= findViewById<TextView>(R.id.userEmailDis)
        val reviewHistory=findViewById<Button>(R.id.HistoryReview)

        val apiClient = application as ApiClient
        session=SessionManager(this)

        var token=session.fetchAuthToken()

        session= SessionManager(this)
        emailId.text="${session.FetchUserID()}"

        userdelete.setOnClickListener {

            val intent8 = Intent(this,DeleteConfirmationActivity::class.java)
            startActivity(intent8)

        }
        updateemail.setOnClickListener {
            val intent=Intent(this,update_email::class.java)
            startActivity(intent)
        }
        reviewHistory.setOnClickListener{
            val intent1=Intent(this,LoginHistory::class.java)
            startActivity(intent1)
        }
    }
}