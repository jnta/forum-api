package com.github.jnta.forumapi.services

import com.github.jnta.forumapi.payload.forms.CourseForm
import com.github.jnta.forumapi.payload.views.CourseView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CourseService {
    fun create(form: CourseForm): CourseView

    fun findById(id: Long): CourseView

    fun findAll(pageable: Pageable): Page<CourseView>

    fun update(id: Long, form: CourseForm): CourseView

    fun delete(id: Long)
}