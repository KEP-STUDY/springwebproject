package com.example.kotlinweb.board.controller
import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(private val boardService: BoardService) {

    @GetMapping(value = ["/board"])
    fun findAllPosts(): ResponseEntity<Any> {;
        return ResponseEntity(boardService.findPosts(), HttpStatus.OK);
    }

    @PostMapping(value = ["/board"])
    fun savePost(@RequestBody post: Post): ResponseEntity<Any> {
        return ResponseEntity(boardService.savePost(post), HttpStatus.CREATED);
    }

    @PutMapping(value = ["/board/{id}"])
    fun updatePost(@RequestBody post: Post, @PathVariable id: String): ResponseEntity<Any> {
        return ResponseEntity(boardService.updatePost(post), HttpStatus.OK);
    }

    @DeleteMapping(value = ["/board"])
    fun deletePost(@RequestBody post: Post): ResponseEntity<Any> {
        return ResponseEntity(boardService.deletePost(post), HttpStatus.OK);
    }

}