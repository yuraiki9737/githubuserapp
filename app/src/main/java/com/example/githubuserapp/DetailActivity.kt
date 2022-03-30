package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val data = intent.getParcelableExtra<User>(DATA_USER) as User
        binding.tvItemName.text = data.name
        binding.tvItemUsername.text = data.username
        binding.imgItemPhoto.setImageResource(data.avatar)
        binding.tvItemCompany.text = data.repository
        binding.tvItemLocation.text = data.company
        binding.tvItemRepository.text = data.location
        binding.tvItemFollowers.text = data.followers
        binding.tvItemFollowing.text = data.following


    }
    companion object {
        const val DATA_USER = "DATA"
    }
}
