package com.example.kotlinweb.controller

import com.example.kotlinweb.model.Board
import com.example.kotlinweb.model.Response
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
class BoardControllerTest {


    @Autowired
    private lateinit var mockMvc:MockMvc



    companion object{
        private val objectMapper:ObjectMapper = jacksonObjectMapper()
    }



    @Test
    @Order(1)
    fun createBoard(){
        val board = Board("abcd","abcd","안녕하세요")
        val result = mockMvc.perform(MockMvcRequestBuilders.post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(board)))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.name, board.name)
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }
    @Test
    @Order(2)
    fun findBoard(){
        val board = Board("abcd","abcd","안녕하세요")
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/board/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.name, board.name)
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }

    @Test
    @Order(3)
    fun findAllBoard(){
        val result = mockMvc.perform(MockMvcRequestBuilders.get("/board")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<List<Board>>>(){})
        assertEquals(resultPayload.data.size, 1)
    }

    @Test
    @Order(4)
    fun updateBoard(){
        val board = Board("abcd","abcd","안녕하세요2")
        val result = mockMvc.perform(MockMvcRequestBuilders.put("/board/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(board)))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Board>>(){})
        assertEquals(resultPayload.data.name, board.name)
        assertEquals(resultPayload.data.title, board.title)
        assertEquals(resultPayload.data.content, board.content)
    }

    @Test
    @Order(5)
    fun deleteBoard(){
        val result = mockMvc.perform(MockMvcRequestBuilders.delete("/board/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        val resultPayload = objectMapper.readValue(result.response.contentAsString, object : TypeReference<Response<Boolean>>(){})
        assertEquals(resultPayload.data, true)
    }

}