package com.github.jnta.forumapi.payload.views

import com.github.jnta.forumapi.enums.Category

data class CourseView(
    val id: Long? = null,
    val name: String,
    val category: Category,
)
