package com.kong.dashboard.controller

import com.kong.dashboard.repository.BoardRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api
@RestController
@RequestMapping("/board")
class BoardController{

    @ApiOperation(value = "find all board")
    @GetMapping()
    fun findAllUser(): ResponseEntity<BoardRepository> {
        return ResponseEntity.ok(BoardRepository())
    }
}