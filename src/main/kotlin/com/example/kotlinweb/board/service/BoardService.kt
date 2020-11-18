package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.event.PostSaveEvent
import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class BoardService(
    private val postRepository: PostRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @Transactional
    fun savePost(post: Post) {
        postRepository.save(post)
        applicationEventPublisher.publishEvent(PostSaveEvent(post.id, "게시글 작성이 완료 되었습니다."))
    }

    @Transactional(readOnly = true)
    fun findPostById(id: Long): Post? {
        return postRepository.findByIdOrNull(id)
    }

    @Transactional(readOnly = true)
    fun findPosts(): MutableList<Post> {
        return postRepository.findAll()
    }

    @Transactional
    fun updatePost(post: Post) {
        print(post.toString())
        var foundPost: Post = postRepository.findByIdOrNull(post.id) as Post
        foundPost.text = post.text
        foundPost.title = post.title
    }

    @Transactional
    fun deletePost(post: Post) {
        var foundPost: Post = postRepository.findById(post.id) as Post
        foundPost?.let {
            postRepository.delete(post)
        }
    }
}