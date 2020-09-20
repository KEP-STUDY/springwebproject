package com.example.kotlinweb.controller

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.model.User
import com.example.kotlinweb.model.response.Response
import com.example.kotlinweb.repository.UserRepository
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(value = ["test"])
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BoardControllerTest {


    @Autowired
    private lateinit var mockMvc:MockMvc

    @Autowired
    private lateinit var userRepository: UserRepository

    companion object{

        private val objectMapper:ObjectMapper = jacksonObjectMapper()
        private val user = User("123","123","123","123")
    }

    @BeforeAll
    fun init(){
        userRepository.save(user)
    }


    @Test
    @Order(1)
    fun createBoard(){
        val board = Board(null,"abcd","abcd",user)
        val result = mockMvc.perform(MockMvcRequestBuilders.post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(board))
                .header("Authorization","123"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }
    @Test
    @Order(2)
    fun findBoard(){
        val board = Board(null,"abcd","abcd",user)
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","123"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }

    @Test
    @Order(3)
    fun findAllBoard(){
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","123"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<List<Board>>>(){})
        assertEquals(resultPayload.data.size, 1)
    }

    @Test
    @Order(4)
    fun updateBoard(){
        val board = Board(null,"abcd","abcd",user)
        val result = mockMvc.perform(MockMvcRequestBuilders.put("/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(board))
                .header("Authorization","123"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }

    @Test
    @Order(5)
    fun deleteBoard(){
        val result = mockMvc.perform(MockMvcRequestBuilders.delete("/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","123"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Boolean>>(){})
        assertEquals(resultPayload.data, true)
    }

}