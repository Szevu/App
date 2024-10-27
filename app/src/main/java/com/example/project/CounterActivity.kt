package com.example.project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project.databinding.ActivityCounterBinding


class CounterActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityCounterBinding
    private var textView: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCounterBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        binding.textView.text = textView.toString()

        binding.switch1.setOnClickListener{
            if(binding.switch1.isChecked){
                binding.button.text = "+2".toString()
                binding.button2.text = "-2".toString()
                binding.textView2.text = getString(R.string.dou)
            }else{
                binding.button.text = "+".toString()
                binding.button2.text = "-".toString()
                binding.textView2.text = getString(R.string.singly)
            }
        }


        binding.button.setOnClickListener{

            val Aktualana = binding.textView.text.toString().toInt()

            if(binding.switch1.isChecked){
                val Nowa = Aktualana + 2
                binding.textView.text = Nowa.toString()
            }else{
                val Nowa = Aktualana + 1
                binding.textView.text = Nowa.toString()
            }

        }

        binding.button2.setOnClickListener{

            val Aktualana = binding.textView.text.toString().toInt()

            if(binding.switch1.isChecked){
                val Nowa = Aktualana  - 2
                binding.textView.text = Nowa.toString()
            }else{
                val Nowa = Aktualana - 1
                binding.textView.text = Nowa.toString()
            }
        }

        binding.button3.setOnClickListener{
            textView = 0
            binding.textView.text = textView.toString()
        }

        binding.button4.setOnClickListener{

            val text = binding.editTextNumber.text.toString()

            if(text.isNotEmpty()){
                val liczba = text.toInt()
                val liczbaA = binding.textView.text.toString().toInt()
                val wynik = liczba + liczbaA
                binding.textView.text = wynik.toString()
                binding.editTextNumber.text = null
            }
        }
    }
}