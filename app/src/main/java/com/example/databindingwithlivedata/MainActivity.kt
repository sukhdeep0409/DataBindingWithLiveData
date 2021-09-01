package com.example.databindingwithlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingwithlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /**
        binding.btnUpdate.setOnClickListener {
            mainViewModel.updateQuote()
        }

         no need for above code as it is replaced by code written in xml file
        */

        binding.mainViewModel = mainViewModel

        /**
        mainViewModel.quoteLiveData.observe(this, {
        binding.quoteText.text = it
        })

        no need for above code as it is replaced by code written in xml file
         */

        //we need to tell live data that owner is this ie., MainActivity
        binding.lifecycleOwner = this
    }
}