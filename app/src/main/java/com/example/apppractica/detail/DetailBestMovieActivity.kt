package com.example.apppractica.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.apppractica.IMAGE_BASE
import com.example.apppractica.databinding.ActivityDetailMovieBinding
import com.example.apppractica.models.BestMovies


class DetailBestMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var movies: BestMovies? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia del view binding
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        movies = intent.getParcelableExtra(EXTRA_DATA)

        binding.tvTitle.text=movies?.title
        binding.tvOriginalTitle.text=movies?.title
        binding.tvSecondTitle.text=movies?.original_title
        binding.tvReleaseDate.text=movies?.release_date
        binding.tvOriginalLanguage.text=movies?.original_language
        binding.tvOverview.text=movies?.overview
        binding.tvVoteAverage.text= movies?.vote_average.toString()

        Glide.with(binding.imgPoster).load(IMAGE_BASE + movies!!.poster).into(binding.imgPoster)
        Glide.with(binding.imgVideoPlay).load(IMAGE_BASE + movies!!.poster).into(binding.imgVideoPlay)

        binding.tvBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}