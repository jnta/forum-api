package com.github.jnta.forumapi.payload.mapper

import com.github.jnta.forumapi.entities.Topic
import com.github.jnta.forumapi.payload.views.TopicView
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createdAt = t.createdAt
        )
    }
}