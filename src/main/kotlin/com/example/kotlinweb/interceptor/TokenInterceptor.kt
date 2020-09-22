package com.example.kotlinweb.interceptor

import com.example.kotlinweb.model.UserContext
import com.example.kotlinweb.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import java.lang.RuntimeException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TokenInterceptor(
        private val userService: UserService
): HandlerInterceptorAdapter(){
    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val headerMap: MutableMap<String, String> = HashMap()
        request.headerNames.toList().map { headerMap[it.toLowerCase()] = request.getHeader(it) }

        val token = headerMap["authorization"] ?: throw RuntimeException("not found authorization token")

        val user = userService.getUserByToken(token)
        UserContext.setUser(user)

        return super.preHandle(request, response, handler)
    }

    @Throws(Exception::class)
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        UserContext.removeAll()
        super.postHandle(request, response, handler, modelAndView)
    }
}