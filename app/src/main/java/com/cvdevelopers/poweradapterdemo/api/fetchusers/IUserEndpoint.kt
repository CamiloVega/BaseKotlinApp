package com.cvdevelopers.poweradapterdemo.api.fetchusers

import com.cvdevelopers.poweradapterdemo.api.models.UserAPI

interface IUserEndpoint {
    fun fetchUsers(): List<UserAPI>
}