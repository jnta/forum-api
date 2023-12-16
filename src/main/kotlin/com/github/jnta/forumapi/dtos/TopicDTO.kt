package com.github.jnta.forumapi.dtos

import com.github.jnta.forumapi.enums.TopicStatus

data class TopicDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus
)
