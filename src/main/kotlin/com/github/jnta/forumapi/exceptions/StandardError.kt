package com.github.jnta.forumapi.exceptions

import java.time.LocalDateTime

data class StandardError(
    val time: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
