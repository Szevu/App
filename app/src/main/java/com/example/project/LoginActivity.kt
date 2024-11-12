package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val LoginDane = "root"
    private val PassDane = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button5.setOnClickListener{
            val login = binding.editTextText.text.toString().trim()
            val pass = binding.editTextTextPassword.text.toString().trim()

            if(login.isEmpty()){
                binding.login.error = getString(R.string.error_login_empty)
            } else{
                binding.login.error = null
            }

            if(pass.isEmpty()){
                binding.password.error = getString(R.string.error_password_empty)
            } else{
                binding.password.error = null
            }

            if (login == LoginDane && pass == PassDane){
                Handler(Looper.getMainLooper()).postDelayed(object : Runnable{
                    override fun run(){
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                        finish()
                    }
                }, 3000)
            } else{
                Toast.makeText(this, getString(R.string.login_f), Toast.LENGTH_SHORT).show()
            }
        }

    }
}