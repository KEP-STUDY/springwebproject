package com.example.kotlinweb

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@ActiveProfiles(value = ["test"])
class StudyApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Transactional
    fun contextLoads() {
        mockMvc.perform(get("/health_check.html"))
                .andExpect(status().isOk)
                .andDo(print())
    }

}