package com.kong.dashboard

import com.kong.dashboard.entity.User
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class StudyApplicationTests {

    @Test
    @Transactional
    fun contextLoads() {
        val user = User(null,"hi")

    }

}