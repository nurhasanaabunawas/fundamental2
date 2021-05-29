package com.dicoding.caca.fundamental1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.caca.fundamental1.data.model.FollowersResponse
import com.dicoding.caca.fundamental1.ui.adapter.FollowersAdapter
import com.dicoding.caca.fundamental1.ui.viewmodel.MajorViewModel
import com.dicoding.caca.fundamental1.util.Status
import com.dicoding.caca.fundamental1.databinding.FragmentFollowersBinding


class FollowerFragment : Fragment(){
    private val taskBind get() = fragmentBinding!!
    private var fragmentBinding : FragmentFollowersBinding? = null
    private lateinit var AdapterUnit: FollowersAdapter
    private lateinit var major :MajorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = FragmentFollowersBinding.inflate(inflater, container, false)
        return taskBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val basic = arguments?.getString(UserDetail.EXTRA_DATA).toString()
        ViewModelSettle()
        getData(basic)
    }

    private fun setStatusVisibility (status: Int){
        when(status){
            2-> { taskBind.apply{
                rvFollowers.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            }}
            3-> {taskBind.apply{
                rvFollowers.visibility = View.VISIBLE
                progressLoad.visibility=  View.GONE
            }}

        }
    }
    private fun bindRecyclerView(){
        taskBind.rvFollowers.layoutManager = LinearLayoutManager(context)
        AdapterUnit = FollowersAdapter(arrayListOf())
        taskBind.rvFollowers.adapter = AdapterUnit
    }
    private fun ViewModelSettle(){
       /* major = ViewModelProviders.of(this, ViewModelManufacture(APIHelper(APIUser.apiAsisst)))
            .get(MajorViewModel::class.java)*/
    }
    private fun getData(query : String){
        /*major.getFollowers(query).observe(viewLifecycleOwner, {
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
    private fun addFollowers(Lists : List<FollowersResponse>){
        bindRecyclerView()
        AdapterUnit.apply {
            addfollowers(Lists)
            notifyDataSetChanged()
        }
    }
}
