package com.asadmansr.glideapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.asadmansr.glideapplication.photo.PhotoAdapter
import com.asadmansr.glideapplication.photo.PhotoProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val gridSpanCount = 3
    private val profilePicUrl = "https://source.unsplash.com/random"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val photoAdapter = PhotoAdapter(PhotoProvider.photos)
        rvPhotos.layoutManager = GridLayoutManager(this, gridSpanCount)
        rvPhotos.adapter = photoAdapter

        loadProfilePicture(profilePicUrl)
    }

    private fun loadProfilePicture(url: String) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_profile_placeholder)
            .error(R.drawable.ic_profile_placeholder)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .transform(CircleCrop())
            .into(ivProfile)
    }
}
