package com.github.jnta.forumapi.payload.forms

import com.github.jnta.forumapi.enums.Category

data class CourseForm(
    val name: String,
    val category: Category,
)
