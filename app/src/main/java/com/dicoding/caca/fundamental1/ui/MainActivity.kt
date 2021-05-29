package com.dicoding.caca.fundamental1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.caca.fundamental1.R
import com.dicoding.caca.fundamental1.databinding.ActivityMainBinding
import com.dicoding.caca.fundamental1.ui.adapter.SearchResultAdapter
import com.dicoding.caca.fundamental1.ui.viewmodel.MajorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SearchResultAdapter
    private lateinit var taskBind: ActivityMainBinding
    private lateinit var major: MajorViewModel

    companion object {
        private const val TAG = "Main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(taskBind.root)

        DesignSettle()
        ViewModelSettle()

        taskBind.searchView.queryHint = getString(R.string.search)
        taskBind.searchView.onActionViewExpanded()
        setStatusVisibility(1)
        taskBind.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                observeData(query)
                Log.d(TAG, query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        /*taskBind.searchView.clearFocus()*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.lang_setting -> {
                val setting = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(setting)
            }
        }
        return true
    }

    private fun ViewModelSettle() {
        major = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MajorViewModel::class.java)
    }

    private fun DesignSettle() {
        adapter = SearchResultAdapter()
        taskBind.rvUsers.layoutManager = LinearLayoutManager(this)
        taskBind.rvUsers.adapter = adapter
        taskBind.rvUsers.setHasFixedSize(true)
    }

    private fun observeData(query: String) {
        major.getUsers(query).observe(this, {
            adapter.newUsers(it)
            setStatusVisibility(3)
        })
    }

    private fun setStatusVisibility(status: Int) {
        when (status) {
            1 -> {
                taskBind.apply {
                    rvUsers.visibility = View.GONE
                    progressLoad.visibility = View.GONE
                }
            }
            2 -> {
                taskBind.apply {
                    rvUsers.visibility = View.GONE
                    progressLoad.visibility = View.VISIBLE
                }
            }
            3 -> {
                taskBind.apply {
                    rvUsers.visibility = View.VISIBLE
                    progressLoad.visibility = View.GONE
                }
            }
        }
    }
}