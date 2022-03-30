package com.example.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
        get() {
            val userName = resources.getStringArray(R.array.username)
            val photo = resources.obtainTypedArray(R.array.avatar)
            val name = resources.getStringArray(R.array.name)
            val company = resources.getStringArray(R.array.company)
            val location = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val listUser = ArrayList<User>()
            for (i in name.indices) {
                val user = User(
                    userName[i],
                    name[i],
                    photo.getResourceId(i, -1),
                    location[i],
                    dataRepository[i],
                    company[i],
                    dataFollowers[i],
                    dataFollowing[i]
                )
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = GridLayoutManager(this, 2)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveIntent.putExtra(DATA_USER, data)
                startActivity(moveIntent)

            }
        })
    }


    companion object{
        const val DATA_USER = "DATA"
    }

}
