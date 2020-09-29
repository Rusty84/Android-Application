package com.testing.app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.testing.app.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            var status = if (username_field.text.toString().equals("User")
                && password_field.text.toString().equals("Password")
            ) "Login Successful" else "Login failed. Please check your Username and Password and try again."
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()

            if (status == "Login Successful") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        }

    }
}