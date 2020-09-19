package me.harry.study.router

import me.harry.study.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class UserRouter {
    @Bean
    fun route(userHandler: UserHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route(GET("/user/{id}")
                .and(accept(MediaType.APPLICATION_JSON)), userHandler::readUser)
                .andRoute(POST("/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::createUser)
                .andRoute(DELETE("/user/{id}"), userHandler::deleteUser)
                .andRoute(PUT("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::updateUser)
    }
}