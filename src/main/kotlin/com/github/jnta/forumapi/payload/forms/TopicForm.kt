package com.github.jnta.forumapi.payload.forms

import com.github.jnta.forumapi.enums.Category
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicForm(
    @field:NotEmpty @field:Size(min = 5, max = 100) val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val category: Category,
)
