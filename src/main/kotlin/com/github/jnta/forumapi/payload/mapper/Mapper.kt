package com.github.jnta.forumapi.payload.mapper

fun interface Mapper<T, U> {
    fun map(t: T): U
}