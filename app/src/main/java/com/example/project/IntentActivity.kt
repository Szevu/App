package com.example.project

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.Phonebtn.setOnClickListener{
            val PhoneNumber = binding.PhoneEdit.text.toString()
            if(PhoneNumber.length >= 9 && PhoneNumber.isDigitsOnly()){
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${PhoneNumber})"))
                startActivity(intent)
            }else{
                Toast.makeText(this, getString(R.string.phonewalid), Toast.LENGTH_SHORT).show()
            }
            binding.PhoneEdit.text.clear()
        }

        binding.searchbtn.setOnClickListener {
            val SearchValue = binding.searchedit.text.toString()
            if(SearchValue.isNotBlank()){
                val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                    putExtra(SearchManager.QUERY, SearchValue)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, getString(R.string.searchID), Toast.LENGTH_SHORT).show()
            }
            binding.searchedit.text.clear()
        }

        binding.linkbtn.setOnClickListener {
            val url = binding.linkedit.text.toString()
            if(url.isNotBlank() && (url.startsWith("http://") || url.startsWith("https://"))){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }else{
                Toast.makeText(this, getString(R.string.url), Toast.LENGTH_SHORT).show()
            }
            binding.linkedit.text.clear()

        }

        binding.locationBTN.setOnClickListener {
            val location = binding.locationSearch.text.toString()
            if(location.isNotBlank()){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${location}"))
                startActivity(intent)
            }else{
                Toast.makeText(this, getString(R.string.locations), Toast.LENGTH_SHORT).show()
            }
            binding.locationSearch.text.clear()
        }
    }
}