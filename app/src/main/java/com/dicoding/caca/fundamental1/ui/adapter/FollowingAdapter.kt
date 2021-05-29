@file:Suppress("DEPRECATION")

package com.dicoding.caca.fundamental1.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.caca.fundamental1.R
import com.dicoding.caca.fundamental1.data.model.FollowingResponse
import com.dicoding.caca.fundamental1.databinding.UserItemBinding
import com.dicoding.caca.fundamental1.ui.UserDetail

class FollowingAdapter (private val list: ArrayList<FollowingResponse>) :
    RecyclerView.Adapter<FollowingAdapter.DataHolder>(){

        inner class DataHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val taskBind = UserItemBinding.bind(view)

            internal fun bind(following: FollowingResponse?) {
                if (following != null) {
                    val into = Glide.with(itemView.context)
                    .load(following.picUrl) .into(taskBind.imgAvatar)
                    taskBind.txtName.text = following.login
                }
            }

            init{
                view.setOnClickListener {
                    val site: Int = adapterPosition
                    val key_login: String? = list[site].login
                    val intent = Intent(itemView.context, UserDetail::class.java)
                    intent.putExtra(UserDetail.EXTRA_DATA, key_login)
                    itemView.context.startActivity(intent)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FollowingAdapter.DataHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, site: Int) {
        holder.bind(list[site])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addFollowingData(users: List<FollowingResponse>) {
        this.list.apply {
            clear()
            addAll(users)
        }
    }
}