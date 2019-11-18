package com.cvdevelopers.poweradapterdemo.api.mock

import com.cvdevelopers.poweradapterdemo.R
import com.cvdevelopers.poweradapterdemo.api.fetchusers.IUserEndpoint
import com.cvdevelopers.poweradapterdemo.api.models.UserAPI
import com.cvdevelopers.poweradapterdemo.util.RawJsonReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MockUserEndpointImpl @Inject constructor (private val rawJsonReader: RawJsonReader, private val gson: Gson): IUserEndpoint {
    override fun fetchUsers(): List<UserAPI> {
        val userJson = rawJsonReader.readJson(R.raw.users)
        val listType = object : TypeToken<List<UserAPI>>() {}.getType()
        return gson.fromJson(userJson, listType)
    }

}