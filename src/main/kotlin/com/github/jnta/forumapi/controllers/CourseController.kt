package com.github.jnta.forumapi.controllers

import com.github.jnta.forumapi.payload.forms.CourseForm
import com.github.jnta.forumapi.payload.views.CourseView
import com.github.jnta.forumapi.services.CourseService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("\${forum.base.path}/courses")
class CourseController(val service: CourseService) {
    @PostMapping
    fun postTopic(@RequestBody @Valid form: CourseForm): ResponseEntity<CourseView> {
        val created = service.create(form)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path(created.id.toString())
            .build().toUri()
        return ResponseEntity.created(uri).body(created)
    }

    @GetMapping
    fun getTopics(@PageableDefault pageable: Pageable): ResponseEntity<Page<CourseView>> {
        return ResponseEntity.ok(service.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun getTopic(@PathVariable id: Long): ResponseEntity<CourseView> {
        return ResponseEntity.ok(service.findById(id))
    }

    @PutMapping("/{id}")
    fun putTopic(@PathVariable id: Long, @RequestBody @Valid form: CourseForm): ResponseEntity<CourseView> {
        return ResponseEntity.ok(service.update(id, form))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) = service.delete(id)
}