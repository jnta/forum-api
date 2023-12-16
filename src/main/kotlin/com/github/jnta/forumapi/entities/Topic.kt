package com.github.jnta.forumapi.entities

import com.github.jnta.forumapi.enums.TopicStatus
import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val responses: Collection<Response> = HashSet(),
)
