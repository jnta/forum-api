package com.github.jnta.forumapi.servicesimpl

import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.exceptions.ResourceNotFoundException
import com.github.jnta.forumapi.payload.forms.TopicForm
import com.github.jnta.forumapi.payload.mapper.TopicFormMapper
import com.github.jnta.forumapi.payload.mapper.TopicViewMapper
import com.github.jnta.forumapi.payload.views.TopicView
import com.github.jnta.forumapi.repositories.TopicRepository
import com.github.jnta.forumapi.services.TopicService
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    val repository: TopicRepository,
    val topicFormMapper: TopicFormMapper,
    val topicViewMapper: TopicViewMapper
) : TopicService {
    override fun create(topicForm: TopicForm): TopicView {
        topicFormMapper.map(topicForm).let {
            return topicViewMapper.map(repository.save(it))
        }
    }

    override fun findById(id: Long): TopicView {
        return topicViewMapper.map(repository.findById(id).orElseThrow {
            ResourceNotFoundException(Topic::class.java, id)
        })
    }

    override fun findAll(pageable: Pageable): Page<TopicView> {
        return repository.findAll(pageable).map { topic: Topic -> topicViewMapper.map(topic) }
    }

    @Transactional
    override fun update(id: Long, topicForm: TopicForm): TopicView {
        repository.findById(id).orElseThrow {
            ResourceNotFoundException(Topic::class.java, id)
        }.let {
            it.title = topicForm.title
            it.message = topicForm.message
            return topicViewMapper.map(repository.save(it))
        }
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }
}