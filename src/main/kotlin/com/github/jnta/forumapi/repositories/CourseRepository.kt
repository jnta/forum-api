package com.github.jnta.forumapi.repositories

import com.github.jnta.forumapi.entities.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long>