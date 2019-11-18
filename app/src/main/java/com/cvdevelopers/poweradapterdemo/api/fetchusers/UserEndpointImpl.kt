package com.cvdevelopers.poweradapterdemo.api.fetchusers

import com.cvdevelopers.poweradapterdemo.api.models.UserAPI
import javax.inject.Inject

class UserEndpointImpl @Inject constructor():
    IUserEndpoint {
    override fun fetchUsers(): List<UserAPI> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}