package com.github.jnta.forumapi.payload.mapper

import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.payload.forms.TopicForm
import com.github.jnta.forumapi.services.CourseService
import com.github.jnta.forumapi.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(val courseService: CourseService, val userService: UserService) : Mapper<TopicForm, Topic> {
    override fun map(t: TopicForm): Topic {
        return Topic(
            category = t.category,
            message = t.message,
            title = t.title,
            course = courseService.findById(t.courseId),
            author = userService.getAuthenticatedUser(),
        )
    }
}