package com.cvdevelopers.poweradapterdemo.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cvdevelopers.poweradapterdemo.api.fetchusers.IUserEndpoint
import com.cvdevelopers.poweradapterdemo.userlist.model.UserListDisplayData
import com.cvdevelopers.poweradapterdemo.userlist.model.UserOneRecyclerItem
import javax.inject.Inject

class UserListViewModel @Inject constructor(private val endpointUsers: IUserEndpoint): ViewModel() {

    val dataStream = MutableLiveData<UserListDisplayData>()

    fun postString() = dataStream.postValue(UserListDisplayData("Test Value"))

    fun fetchUsers() {
        endpointUsers.fetchUsers()
            .mapIndexed { index, userAPI -> UserOneRecyclerItem(index, userAPI.name) }
            .apply {
                dataStream.postValue(UserListDisplayData(userList = this))
            }

    }

}