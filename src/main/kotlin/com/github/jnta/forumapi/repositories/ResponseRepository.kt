package com.github.jnta.forumapi.repositories

import com.github.jnta.forumapi.entities.Response
import org.springframework.data.jpa.repository.JpaRepository

interface ResponseRepository : JpaRepository<Response, Long>