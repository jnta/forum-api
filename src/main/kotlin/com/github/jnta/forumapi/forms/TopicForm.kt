package com.github.jnta.forumapi.forms

data class TopicForm(
    val title: String,
    val message: String,
    val courseId: Long,
    val categoryId: Long
)
