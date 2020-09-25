package com.example.kotlinweb.e2e.user

import com.example.kotlinweb.entity.User
import com.example.kotlinweb.model.CreateUserRequest
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.http.MediaType

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
@ActiveProfiles(value = ["test"])
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc
    val objectMapper = jacksonObjectMapper()

    @Test
    @Transactional
    fun getAllUser() {
        // GIVEN
        // WHEN
        val apiResult = mockMvc.perform(get("/user"))
                .andExpect(status().isOk)
                .andReturn()
        // THEN
        val result =objectMapper.readValue(apiResult.response.contentAsString, object : TypeReference<List<User>>(){})

        assertEquals( result , listOf<User>())
    }

    @Test
    @Transactional
    fun createUser() {
        // GIVEN
        val randomName = Math.random().toString()
        // WHEN
        val createUserRequestApi = mockMvc.perform(
                    post("/user")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( objectMapper.writeValueAsString(CreateUserRequest(name = randomName)))
                )
                .andExpect(status().isOk)
                .andReturn()
        val createUserResult = objectMapper.readValue(createUserRequestApi.response.contentAsString, object : TypeReference<User>(){})

        val userId = createUserResult.id
        val getUserRequestApi = mockMvc.perform(get("/user/$userId"))
                .andExpect(status().isOk)
                .andReturn()

        val result = objectMapper.readValue(getUserRequestApi.response.contentAsString, object : TypeReference<User>(){})
        // THEN
        assertEquals(result,createUserResult)
    }
}