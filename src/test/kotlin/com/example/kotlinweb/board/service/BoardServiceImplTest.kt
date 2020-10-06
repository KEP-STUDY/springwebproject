package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostCrudRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class BoardServiceImplTest(
    @Autowired val repository: PostCrudRepository
) {

    @Test
    fun savePostTest() {
        val post: Post = Post(1L, "Test Title", "KDH", "memo")
        val boardService: BoardService = BoardServiceImpl(repository)
        boardService.savePost(post)
        val savedPost: Post? = boardService.findPostbyId(1L)
        if (savedPost != null) {
            Assertions.assertEquals(post.title, savedPost.title)
        }
    }

    @Test
    fun readPostsTest() {
        val post1: Post = Post(1L, "Test Title", "KDH", "memo1")
        val post2: Post = Post(2L, "Test Title2", "KDH2", "memo2")
        val boardService: BoardService = BoardServiceImpl(repository)
        boardService.savePost(post1)
        boardService.savePost(post2)

        val posts: MutableList<Post> = boardService.findPosts()
        val savedPost1: Post = posts[0] as Post
        val savedPost2: Post = posts[1] as Post
        assertAll(
            "posts",
            { Assertions.assertEquals(post1.title, savedPost1.title) },
            { Assertions.assertEquals(post2.writer, savedPost2.writer) }
        )
    }
}