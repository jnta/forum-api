package com.github.jnta.forumapi.payload.mapper

import com.github.jnta.forumapi.entities.Course
import com.github.jnta.forumapi.payload.forms.CourseForm
import org.springframework.stereotype.Component

@Component
class CourseFormMapper : Mapper<CourseForm, Course> {
    override fun map(t: CourseForm): Course {
        return Course(
            name = t.name,
            category = t.category,
        )
    }
}