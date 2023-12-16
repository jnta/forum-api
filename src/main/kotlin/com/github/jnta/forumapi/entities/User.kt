package com.github.jnta.forumapi.entities

data class User(
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
)
