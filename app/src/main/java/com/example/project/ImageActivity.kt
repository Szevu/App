package com.example.project

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private val imageList = listOf(
        R.drawable.ob1,
        R.drawable.ob2,
        R.drawable.ob3,
        R.drawable.ob4,
        R.drawable.ob5,
        R.drawable.ob6,
        R.drawable.ob7,
        R.drawable.ob8,
        R.drawable.ob9,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var imageF = binding.ImageFish
        imageF.setImageResource(getRandomIMG())
        imageF.layoutParams.width = 200
        imageF.layoutParams.height = 200

        binding.randomImageBTN.setOnClickListener {
            imageF.setImageResource(getRandomIMG())
        }

        binding.MonoBTN.setOnClickListener{
            if(binding.MonoBTN.isChecked){
                val colorMatrix = ColorMatrix()
                colorMatrix.setSaturation(0f)
                imageF.colorFilter = ColorMatrixColorFilter(colorMatrix)
                binding.MonoBTN.text = getString(R.string.switchchangecolor).toString()
            } else{
                imageF.colorFilter = null
                binding.MonoBTN.text = getString(R.string.switchchangecolor_off)
            }
        }

        binding.BarGrey.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val newSize = progress.coerceIn(1, 666)
                imageF.layoutParams.width = newSize
                imageF.layoutParams.height = newSize
                imageF.requestLayout()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.BarAlfa.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                imageF.imageAlpha = progress.coerceIn(0, 255)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

    private fun getRandomIMG(): Int{
        val index = (0 ..<imageList.size).random()
        return imageList[index]
    }
}