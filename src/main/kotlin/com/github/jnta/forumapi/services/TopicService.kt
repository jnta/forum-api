package com.github.jnta.forumapi.services

import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.forms.TopicForm
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicService {
    fun create(topicForm: TopicForm): Topic

    fun findById(id: Long): Topic

    fun findAll(pageable: Pageable): Page<Topic>

    fun update(id: Long, topicForm: TopicForm): Topic

    fun delete(id: Long)
}