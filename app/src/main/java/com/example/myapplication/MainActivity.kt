package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.adapter.MainAdapter
import com.example.myapplication.service.RetrofitService
import com.example.myapplication.listener.clickListener
import com.example.myapplication.viewmodel.MainRepository
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity(), clickListener {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager= layoutManager

        //viewModel.getAllPep()

        viewModel.getAllPep().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setSongList(it.toMutableList())
        })

        viewModel.errorMessage.observe(this, Observer {

        })

    }

    override fun onItem(res: listItem) {

        val bundle = bundleOf(
            "firstName" to res.firstName,
            "lastName" to res.lastName,
            "jobtitle" to res.jobtitle,
            "email" to res.email,

        )
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Res", bundle)
        startActivity(intent)
    }
}