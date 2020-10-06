package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Post
import com.example.kotlinweb.board.repository.PostCrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class BoardServiceImpl(private val postCrudRepository: PostCrudRepository) : BoardService {

    override fun savePost(post: Post) {
        postCrudRepository.save(post)
    }

    override fun findPostById(id: Long): Post? {
        return postCrudRepository.findByIdOrNull(id)
    }

    override fun findPosts(): MutableList<Post> {
        return postCrudRepository.findAll()
    }

    @Transactional
    override fun updatePost(post: Post) {
        print(post.toString())
        var foundPost: Post = postCrudRepository.findByIdOrNull(post.id) as Post
        foundPost.text = post.text
        foundPost.title = post.title
        foundPost.updateDate = LocalDateTime.now()
    }

    override fun deletePost(post: Post) {
        var foundPost: Post = postCrudRepository.findById(post.id) as Post
        foundPost?.let {
            postCrudRepository.delete(post)
        }
    }
}