package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationEventPublisher
import javax.transaction.Transactional

@SpringBootTest
internal class BoardServiceTest(
    @Autowired val repository: PostRepository,
    @Autowired val applicationEventPublisher: ApplicationEventPublisher
) {

    @Test
    @Tag("fast")
    @Transactional
    fun savePostTest() {
        val post = Post(1L, "Test Title", "KDH", "memo")
        val boardService: BoardService = BoardService(repository, applicationEventPublisher)
        boardService.savePost(post)
        val savedPost: Post? = boardService.findPostById(1L)
        savedPost?.let {
            Assertions.assertEquals(post.title, savedPost.title)
            assertThat(post.title).isEqualTo(savedPost.title)
        }
    }

    @Test
    @Tag("fast")
    @Transactional
    fun readPostsTest() {
        val post1 = Post(1L, "Test Title", "KDH", "memo1")
        val post2 = Post(2L, "Test Title2", "KDH2", "memo2")
        val boardService: BoardService = BoardService(repository, applicationEventPublisher)
        boardService.savePost(post1)
        boardService.savePost(post2)

        val posts: MutableList<Post> = boardService.findPosts()
        val savedPost1: Post = posts[0]
        val savedPost2: Post = posts[1]
        //assertion
        assertAll(
            "posts",
            { Assertions.assertEquals(post1.title, savedPost1.title) },
            { Assertions.assertEquals(post2.writer, savedPost2.writer) }
        )
        //assertJ
        assertAll(
            { assertThat(post1.title).isEqualTo(savedPost1.title) },
            { assertThat(post2.writer).isEqualTo(savedPost2.writer) }
        )
    }

    @Test
    @Tag("fast")
    @Transactional
    fun increaseHitCount() {
        val post1 = Post(1L, "Test Title", "KDH", "memo1")
        post1.increaseHitCount()
        //assertion
        Assertions.assertEquals(post1.hitCount, 1)
        //assertJ
        assertThat(post1.hitCount).isEqualTo(1)

    }
}