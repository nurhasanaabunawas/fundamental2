package com.dicoding.caca.fundamental1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.caca.fundamental1.data.model.FollowingResponse
import com.dicoding.caca.fundamental1.databinding.FragmentFollowingBinding
import com.dicoding.caca.fundamental1.ui.adapter.FollowingAdapter
import com.dicoding.caca.fundamental1.ui.viewmodel.MajorViewModel
import com.dicoding.caca.fundamental1.util.Status

class FollowingFragment : Fragment(){
    private lateinit var AdapterUnit: FollowingAdapter
    private lateinit var major :MajorViewModel
    private var fragmentBinding : FragmentFollowingBinding? = null
    private val taskBind get() = fragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentFollowingBinding.inflate(inflater, container, false)
        return taskBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val basic = arguments?.getString(UserDetail.EXTRA_DATA).toString()
        ViewModelSettle()
        getData(basic)
    }

    private fun bindRecyclerView(){
        taskBind.rvFollowing.layoutManager = LinearLayoutManager(context)
        AdapterUnit = FollowingAdapter(arrayListOf())
        taskBind.rvFollowing.adapter = AdapterUnit
    }

    private fun setStatusVisibility(status: Int){
        when(status){
            2->{taskBind.apply{
                rvFollowing.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            }}
            3-> {taskBind.apply{
                rvFollowing.visibility = View.VISIBLE
                progressLoad.visibility=  View.GONE
            }}

        }
    }

    private fun ViewModelSettle(){
        /*major = ViewModelProviders.of(this, ViewModelManufacture(APIHelper(APIUser.apiAsisst)))
            .get(MajorViewModel::class.java)*/
    }
    private fun getData(query : String){
       /*major.getFollowing(query).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status){
                    Status.SUCCESS -> {
                        setStatusVisibility(3)
                        resource.data?.let {
                            data -> addFollowers(data)
                        }
                    }
                    Status.LOADING -> {
                        setStatusVisibility(2)
                    }
                    Status.ERROR -> {
                        Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })*/
    }
    private fun addFollowers(Lists : List<FollowingResponse>){
        bindRecyclerView()
        AdapterUnit.apply {
            addFollowingData(Lists)
            notifyDataSetChanged()
        }
    }
}
