package com.cvdevelopers.poweradapterdemo.userlist


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.cvdevelopers.poweradapterdemo.R
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject
import com.cvdevelopers.poweradapterdemo.di.vm.ViewModelFactory
import com.cvdevelopers.poweradapterdemo.userlist.model.UserListDisplayData
import com.cvdevelopers.powerrecycleradapter.adapter.RecyclerAdapter
import com.cvdevelopers.powerrecycleradapter.adapter.RecyclerDataSource
import dagger.android.support.AndroidSupportInjection

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var model: UserListViewModel

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    @Inject
    lateinit var dataSource: RecyclerDataSource

    lateinit var adapter: RecyclerAdapter


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = activity?.run {
            ViewModelProviders.of(this, mViewModelFactory).get(UserListViewModel::class.java)

        } ?: throw Exception("Invalid Activity")

        model.dataStream.observe(this, Observer<UserListDisplayData>{ displayData ->
            // update UI
            renderDisplayData(displayData)
        })
        model.postString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = RecyclerAdapter(dataSource)
        user_recycler_view.layoutManager = LinearLayoutManager(this.activity)
        user_recycler_view.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        model.fetchUsers()
    }

    private fun renderDisplayData(data: UserListDisplayData) {
        data.framentTitle?.let {
            fragment_title.text = it
        }
        data.userList?.let {
            dataSource.setData(it)
        }
    }

}
