package me.harry.study.service

import me.harry.study.model.User
import me.harry.study.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.lang.NullPointerException

@Service
class UserService(
        val userRepository: UserRepository
) {
    fun create(user: User): Mono<User> {
        return Mono.fromSupplier {
            userRepository
                    .save(user)
                    .subscribe()
            return@fromSupplier user
        }
    }

    fun getById(id: Long): Mono<User> {
        return userRepository.findById(id)
    }

    fun update(oldUser: User, updatedUser: User): Mono<User> {
        return Mono.fromSupplier {
            userRepository
                    .delete(oldUser)
                    .and(userRepository.save(updatedUser))
                    .subscribe()
            return@fromSupplier updatedUser
        }
    }

    fun delete(user: User): Mono<Void> {
        return Mono.fromSupplier {
            userRepository
                    .delete(user)
                    .subscribe()
            return@fromSupplier null
        }
    }
}