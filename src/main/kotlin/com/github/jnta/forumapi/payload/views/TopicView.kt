package com.github.jnta.forumapi.payload.views

import com.github.jnta.forumapi.enums.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime,
)
