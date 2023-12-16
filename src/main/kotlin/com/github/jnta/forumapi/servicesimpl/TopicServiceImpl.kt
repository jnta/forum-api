package com.github.jnta.forumapi.servicesimpl

import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.exceptions.ResourceNotFoundException
import com.github.jnta.forumapi.forms.TopicForm
import com.github.jnta.forumapi.repositories.TopicRepository
import com.github.jnta.forumapi.services.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(val topicRepository: TopicRepository) : TopicService {
    override fun create(topicForm: TopicForm): Topic {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Topic {
        return topicRepository.findById(id).orElseThrow {
            ResourceNotFoundException(Topic::class.java, id)
        }
    }

    override fun findAll(pageable: Pageable): Page<Topic> {
        return topicRepository.findAll(pageable)
    }

    override fun update(id: Long, topicForm: TopicForm): Topic {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        topicRepository.deleteById(id)
    }
}