@file:Suppress("DEPRECATION")

package com.dicoding.caca.fundamental1.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.caca.fundamental1.R
import com.dicoding.caca.fundamental1.data.model.UserSearchModel
import com.dicoding.caca.fundamental1.databinding.UserItemBinding
import com.dicoding.caca.fundamental1.ui.UserDetail


class SearchResultAdapter : RecyclerView.Adapter<SearchResultAdapter.DataHolder>() {

    private val listUser = ArrayList<UserSearchModel>()

    inner class DataHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val taskBind = UserItemBinding.bind(view)
        internal fun bind(userSearchModel: UserSearchModel?) {
            if (userSearchModel != null) {
                taskBind.txtName.text = userSearchModel.login

                Glide.with(itemView.context)
                        .load(userSearchModel.avatarUrl)
                        .into(taskBind.imgAvatar)
            }
        }

        init {
            view.setOnClickListener {
                val site: Int = adapterPosition
                val login: String? = listUser[site].login
                val intent = Intent(itemView.context, UserDetail::class.java)
                intent.putExtra(UserDetail.EXTRA_DATA, login)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: DataHolder, site: Int) {
        holder.bind(listUser[site])
    }

    override fun getItemCount(): Int = listUser.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)
        return DataHolder(view)
    }

    fun newUsers(users: ArrayList<UserSearchModel>) {
        listUser.apply {
            clear()
            addAll(users)
            notifyDataSetChanged()
        }
    }
}