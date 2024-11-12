package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        val userName = bundle?.getString("userName")?.uppercase()
        binding.textView5.text = getString(R.string.witamy, userName)


        binding.button6.setOnClickListener {
            val intent = Intent(this@MainActivity, CounterActivity::class.java)
            startActivity(intent)
        }

        binding.button7.setOnClickListener {
            val intent = Intent(this@MainActivity, IntentActivity::class.java)
            startActivity(intent)
        }

        binding.button8.setOnClickListener {
            val intent = Intent(this@MainActivity, ImageActivity::class.java)
            startActivity(intent)
        }

        binding.button9.setOnClickListener {
            val intent = Intent(this@MainActivity, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}