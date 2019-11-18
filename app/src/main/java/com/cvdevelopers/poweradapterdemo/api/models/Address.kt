package com.cvdevelopers.poweradapterdemo.api.models


data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)