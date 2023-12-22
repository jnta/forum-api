package com.github.jnta.forumapi.payload.mapper

import com.github.jnta.forumapi.entities.Course
import com.github.jnta.forumapi.payload.views.CourseView
import org.springframework.stereotype.Component

@Component
class CourseViewMapper : Mapper<Course, CourseView> {
    override fun map(t: Course): CourseView {
        return CourseView(
            id = t.id,
            name = t.name,
            category = t.category,
        )
    }
}