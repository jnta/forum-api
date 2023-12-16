package com.github.jnta.forumapi.repositories

import com.github.jnta.forumapi.entities.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long>