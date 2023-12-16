package com.github.jnta.forumapi.controllers

import com.github.jnta.forumapi.dtos.TopicDTO
import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.forms.TopicForm
import com.github.jnta.forumapi.services.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("\${forum.base.path}/topics")
class TopicController(val topicService: TopicService) {

    @PostMapping
    fun postTopic(@RequestBody topicForm: TopicForm): ResponseEntity<TopicDTO> {
        val createdTopic = topicService.create(topicForm)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path(createdTopic.id.toString())
            .build().toUri()
        return ResponseEntity.created(uri).body(
            TopicDTO(
                createdTopic.id,
                createdTopic.title,
                createdTopic.message,
                createdTopic.status
            )
        )
    }

    @GetMapping
    fun getTopics(@PageableDefault pageable: Pageable): ResponseEntity<Page<TopicDTO>> {
        return ResponseEntity.ok(topicService.findAll(pageable).map { topic: Topic ->
            TopicDTO(
                topic.id,
                topic.title,
                topic.message,
                topic.status
            )
        })
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): ResponseEntity<TopicDTO> {
        val topic = topicService.findById(id)
        return ResponseEntity.ok(
            TopicDTO(
                topic.id,
                topic.title,
                topic.message,
                topic.status
            )
        )
    }

    @PutMapping("/{id}")
    fun putTopic(@PathVariable id: Long, @RequestBody topicForm: TopicForm): ResponseEntity<TopicDTO> {
        val topic = topicService.update(id, topicForm)
        return ResponseEntity.ok(
            TopicDTO(
                topic.id,
                topic.title,
                topic.message,
                topic.status
            )
        )
    }

    @DeleteMapping("/{id}")
    fun deleteTopic(@PathVariable id: Long) = topicService.delete(id)
}