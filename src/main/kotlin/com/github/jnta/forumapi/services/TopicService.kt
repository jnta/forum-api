package com.github.jnta.forumapi.services

import com.github.jnta.forumapi.payload.forms.TopicForm
import com.github.jnta.forumapi.payload.views.TopicView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicService {
    fun create(topicForm: TopicForm): TopicView

    fun findById(id: Long): TopicView

    fun findAll(pageable: Pageable): Page<TopicView>

    fun update(id: Long, topicForm: TopicForm): TopicView

    fun delete(id: Long)
}