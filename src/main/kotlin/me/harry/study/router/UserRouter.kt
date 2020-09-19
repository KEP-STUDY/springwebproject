package me.harry.study.router

import me.harry.study.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicate
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class UserRouter {

    @Bean
    fun route(userHandler: UserHandler):RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.GET("/user").and(RequestPredicates.accept(MediaType.TEXT_PLAIN))))

    }

}