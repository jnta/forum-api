package com.github.jnta.forumapi.services

import com.github.jnta.forumapi.entities.User
import com.github.jnta.forumapi.payload.forms.UserForm
import com.github.jnta.forumapi.payload.views.UserView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserService {
    fun create(form: UserForm): UserView

    fun findById(id: Long): UserView

    fun findAll(pageable: Pageable): Page<UserView>

    fun update(id: Long, form: UserForm): UserView

    fun delete(id: Long)

    fun getAuthenticatedUser(): User
}