package com.github.jnta.forumapi.exceptions

class ResourceNotFoundException(
    private val className: Class<*>,
    private val id: Long
) : RuntimeException() {
    override val message: String
        get() = "${className.simpleName} with id $id not found"
}