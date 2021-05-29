package com.dicoding.caca.fundamental1.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.caca.fundamental1.R
import com.dicoding.caca.fundamental1.data.model.UserDetailModel
import com.dicoding.caca.fundamental1.databinding.UserDetailBinding
import com.dicoding.caca.fundamental1.ui.adapter.SlidesAdapter
import com.dicoding.caca.fundamental1.ui.viewmodel.MajorViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class UserDetail : AppCompatActivity() {

    private lateinit var taskBind: UserDetailBinding
    private lateinit var major: MajorViewModel

    companion object {
        var EXTRA_DATA = "login_string"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskBind = UserDetailBinding.inflate(layoutInflater)
        setContentView(taskBind.root)
        val login_string = intent.getStringExtra(EXTRA_DATA) as String
        supportActionBar?.title = login_string
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ViewModelSettle()
        dataObserver(login_string)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }

            R.id.lang_setting -> {
                val setting = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(setting)
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun ViewModelSettle() {
        major = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MajorViewModel::class.java)
    }

    private fun dataObserver(username: String) {
        major.getUserDetail(username).observe(this, {
            loadData(it)
          })
    }

    @SuppressLint("SetTextI18n")
    private fun loadData(users: UserDetailModel) {
        setTab(users.login)
        taskBind.apply {
            detailName.text = users.name
            detailLocation.text = users.location
            detailFollowers.text = "${getString(R.string.followers)} \n ${users.followers.toString()}"
            detailFollowing.text = "${getString(R.string.following)} \n ${users.following.toString()}"
            detailPost.text = "${getString(R.string.post)} \n ${users.public_repository.toString()}"
            Glide.with(this@UserDetail)
                    .load(users.avatarUrl)
                    .apply(RequestOptions().override(55,55))
                    .into(detailAvatar)
        }
    }

    private fun setTab(userLogin: String?) {
        val bundle = Bundle()
        bundle.putString(EXTRA_DATA, userLogin)
        val SlidesAdapter = SlidesAdapter(this, bundle)
        val viewPager: ViewPager2 = taskBind.viewPager
        viewPager.adapter = SlidesAdapter
        val tabLayout: TabLayout = taskBind.tabs

        TabLayoutMediator(tabLayout, viewPager) { tab, site ->
            run {
                when (site) {
                    0 -> tab.text = getString(R.string.followers)
                    1 -> tab.text = getString(R.string.following)
                }
            }
        }.attach()
    }
}
