package com.dicoding.caca.fundamental1.ui.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.caca.fundamental1.ui.FollowerFragment
import com.dicoding.caca.fundamental1.ui.FollowingFragment

class SlidesAdapter (appCompatActivity: AppCompatActivity, private  val userLogin: Bundle ):
    FragmentStateAdapter(appCompatActivity) {
    override fun getItemCount(): Int {
       return  2
    }

    override fun createFragment(site: Int): Fragment {
        var fragment: Fragment? = null
        when (site){
            0 -> fragment = FollowerFragment()
            1 -> fragment = FollowingFragment()
        }
        if (fragment != null){
            fragment.arguments = userLogin
        }
        return fragment as Fragment
    }
}