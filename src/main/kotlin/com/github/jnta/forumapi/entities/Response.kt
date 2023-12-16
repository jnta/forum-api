package com.github.jnta.forumapi.entities

import java.time.LocalDateTime

data class Response(
    val id: Long? = null,
    val message: String,
    val topic: Topic,
    val author: User,
    val solution: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)
