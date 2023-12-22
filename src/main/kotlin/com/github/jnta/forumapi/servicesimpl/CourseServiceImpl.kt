package com.github.jnta.forumapi.servicesimpl

import com.github.jnta.forumapi.entities.Course
import com.github.jnta.forumapi.exceptions.ResourceNotFoundException
import com.github.jnta.forumapi.payload.forms.CourseForm
import com.github.jnta.forumapi.payload.mapper.CourseFormMapper
import com.github.jnta.forumapi.payload.mapper.CourseViewMapper
import com.github.jnta.forumapi.payload.views.CourseView
import com.github.jnta.forumapi.repositories.CourseRepository
import com.github.jnta.forumapi.services.CourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(
    val repository: CourseRepository,
    val courseFormMapper: CourseFormMapper,
    val courseViewMapper: CourseViewMapper
) : CourseService {
    override fun create(form: CourseForm): CourseView {
        courseFormMapper.map(form).let { course ->
            return courseViewMapper.map(repository.save(course))
        }
    }

    override fun findById(id: Long): CourseView {
        return courseViewMapper.map(repository.findById(id).orElseThrow {
            ResourceNotFoundException(Course::class.java, id)
        })
    }

    override fun findAll(pageable: Pageable): Page<CourseView> {
        return repository.findAll(pageable).map(courseViewMapper::map)
    }

    override fun update(id: Long, form: CourseForm): CourseView {
        repository.findById(id).orElseThrow {
            ResourceNotFoundException(Course::class.java, id)
        }.let {
            it.name = form.name
            it.category = form.category
            return courseViewMapper.map(repository.save(it))
        }
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }
}