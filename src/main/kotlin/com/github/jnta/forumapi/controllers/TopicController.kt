package com.github.jnta.forumapi.controllers

import com.github.jnta.forumapi.payload.forms.TopicForm
import com.github.jnta.forumapi.payload.views.TopicView
import com.github.jnta.forumapi.services.TopicService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("\${forum.base.path}/topics")
class TopicController(val service: TopicService) {

    @PostMapping
    fun postTopic(@RequestBody @Valid form: TopicForm): ResponseEntity<TopicView> {
        val created = service.create(form)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path(created.id.toString())
            .build().toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @GetMapping
    fun getTopics(@PageableDefault pageable: Pageable): ResponseEntity<Page<TopicView>> {
        return ResponseEntity.ok(service.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): ResponseEntity<TopicView> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PutMapping("/{id}")
    fun putTopic(@PathVariable id: Long, @RequestBody @Valid form: TopicForm): ResponseEntity<TopicView> {
        return ResponseEntity.ok(service.update(id, form))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) = service.delete(id)
}