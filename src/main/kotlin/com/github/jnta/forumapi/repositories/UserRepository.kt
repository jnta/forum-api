package com.github.jnta.forumapi.repositories

import com.github.jnta.forumapi.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>