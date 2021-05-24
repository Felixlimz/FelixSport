package com.example.felixsport.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.felixsport.R
import com.example.felixsport.core.domain.model.Sport
import com.example.felixsport.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CODE = "1010"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailItem = intent.getParcelableExtra<Sport>(EXTRA_CODE)
        showAll(detailItem!!)
    }

    private fun showAll(detail : Sport){
        detail.let {
            binding.tvName.text = detail.strSport
            binding.tvType.text = detail.strFormat
            binding.tvDescription.text = detail.strDescription
            Glide.with(this@DetailActivity)
                .load(detail.strThumb)
                .into(binding.tvDetailImage)

            var statusFav = detail.strFav
            setFavStatus(statusFav)
            binding.fab.setOnClickListener {
                statusFav = !statusFav
                detailViewModel.setFav(detail, statusFav)
                setFavStatus(statusFav)
            }
        }
    }

    private fun setFavStatus(status : Boolean){
        if (status) binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        else binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
    }
}