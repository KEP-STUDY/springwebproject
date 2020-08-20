package me.harry.study.controller

import me.harry.study.model.User
import me.harry.study.payload.UserJoinRequest
import me.harry.study.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
        val userService: UserService
) {

    @PostMapping("/join")
    fun joinUser(@RequestBody userJoinRequest: UserJoinRequest): String {
        val user = User(name = userJoinRequest.name)
        userService.createUser(user)
        return "성공!"
    }
}