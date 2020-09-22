package com.example.kotlinweb

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
class StudyApplicationTests {

    @Test
    @Transactional
    fun contextLoads() {

    }

}