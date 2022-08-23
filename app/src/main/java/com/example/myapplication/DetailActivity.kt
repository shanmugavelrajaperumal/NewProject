package com.example.myapplication

import android.media.MediaPlayer
import android.net.Uri
import android.os.BaseBundle
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.DetaillayoutBinding
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetaillayoutBinding
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detaillayout)
        binding = DetaillayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val result: Bundle? = intent.extras!!
        var dur = (result!!.get("Res") as BaseBundle).get("email").toString()
        binding.nameValue.text = (result.get("Res") as BaseBundle).get("firstName") as String
        binding.titleValue.text = (result.get("Res") as BaseBundle).get("lastName") as String
        binding.rightsValue.text = (result.get("Res") as BaseBundle).get("jobtitle") as String
        binding.DurationValue.text = dur



    }

}