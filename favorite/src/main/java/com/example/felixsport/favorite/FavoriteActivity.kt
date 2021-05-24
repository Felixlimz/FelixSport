package com.example.felixsport.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.felixsport.core.ui.ListAdapter
import com.example.felixsport.favorite.databinding.ActivityFavoriteBinding
import com.example.felixsport.presentation.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var favoriteBinding: ActivityFavoriteBinding
    private val favViewModel : FavoriteViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(favoriteBinding.root)

        loadKoinModules(vafMod)

        supportActionBar?.title = "Favorite Sport"

        val adapterList = ListAdapter()
        adapterList.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_CODE, it)
            startActivity(intent)
        }

        favoriteBinding.progressBar.visibility = View.VISIBLE

        favViewModel.items.observe(this, {
            favoriteBinding.progressBar.visibility = View.GONE
            adapterList.setData(it)
            if(it.isNotEmpty()) favoriteBinding.emptyes.root.visibility = View.GONE
            else favoriteBinding.emptyes.root.visibility = View.VISIBLE
        })

        with(favoriteBinding.rvItem){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterList
        }

    }
}