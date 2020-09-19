package me.harry.study.handler

import me.harry.study.model.User
import me.harry.study.service.UserService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.*
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import reactor.core.publisher.Mono

@Component
class UserHandler(
        val userService: UserService
) {
    fun createUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val user = serverRequest.bodyToMono(User::class.java)

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(user.flatMap(userService::create), User::class.java))
    }

    fun readUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id").toLong()
        val user = userService.getById(id)
        return user
                .flatMap { ok().contentType(MediaType.APPLICATION_JSON).body(fromPublisher(user, User::class.java)) }
                .switchIfEmpty(notFound().build())
    }

    fun updateUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id").toLong()
        val user = serverRequest.bodyToMono(User::class.java)
        return userService
                .getById(id)
                .flatMap { oldUser ->
                    ok().contentType(MediaType.APPLICATION_JSON)
                            .body(fromPublisher(
                                    user.flatMap { updatedUser -> userService.update(oldUser, updatedUser) }, User::class.java
                            ))
                }
                .switchIfEmpty(notFound().build())
    }

    fun deleteUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable("id").toLong()
        return userService
                .getById(id)
                .flatMap { u -> noContent().build(userService.delete(u)) }
                .switchIfEmpty(notFound().build())
    }
}