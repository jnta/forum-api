package com.github.jnta.forumapi.entities

import com.github.jnta.forumapi.enums.Category

data class Course(
    val id: Long? = null,
    var name: String,
    var category: Category,
)
