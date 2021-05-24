package com.example.felixsport.presentation.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.felixsport.R
import com.example.felixsport.core.data.Resources
import com.example.felixsport.core.ui.ListAdapter
import com.example.felixsport.databinding.ActivityMainBinding
import com.example.felixsport.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterList = ListAdapter()
        adapterList.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_CODE, it)
            startActivity(intent)
        }


        binding.favobut.setOnClickListener{
            Log.e("SHOW ME", "LALALA")
            try {
                startActivity(Intent(this, Class.forName("com.example.felixsport.favorite.FavoriteActivity")))
            } catch (e : Exception){
                Toast.makeText(this, "Feature Not Available ${e.toString()}", Toast.LENGTH_SHORT).show()
                Log.e("FAVORITE", e.toString())
            }
        }

        mainViewModel.items.observe(this,{sport->
            if (sport != null){
                when(sport){
                    is Resources.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resources.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterList.setData(sport.data)
                    }
                    is Resources.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        with(binding.rvItem){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterList
        }
    }
}