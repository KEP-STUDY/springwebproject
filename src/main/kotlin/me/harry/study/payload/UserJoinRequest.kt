package me.harry.study.payload

import com.fasterxml.jackson.annotation.JsonProperty

class UserJoinRequest (
        @JsonProperty("name")
        val name: String
)