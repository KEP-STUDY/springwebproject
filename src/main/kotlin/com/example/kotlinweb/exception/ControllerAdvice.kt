package com.example.kotlinweb.exception

import com.example.kotlinweb.model.response.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException

@ControllerAdvice
class ControllerAdvice(){

    @ExceptionHandler(Exception::class)
    private fun handleUnexpectedHandler(exception: Exception): ResponseEntity<Response<*>> {
        return makeResponseException(exception)
    }

    private fun makeResponseException(exception: Exception): ResponseEntity<Response<*>>{
        return when(exception){
            is HttpClientErrorException.BadRequest ->{
                makeResponse(exception.message, HttpStatus.BAD_REQUEST)
            }
            else -> {
                makeResponse(exception.message,HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }
    private fun makeResponse(message:String?, status:HttpStatus, data:Any? = null):ResponseEntity<Response<*>>{
        return ResponseEntity(Response(code = status, message = message?.let { message }
                ?: "", data = data), status)
    }
}
