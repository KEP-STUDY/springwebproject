package com.example.kotlinweb.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "PUT", "DELETE", "POST", "OPTIONS")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
    }

    @Bean
    fun characterEncodingFilter(): CharacterEncodingFilter {
        val characterEncodingFilter: CharacterEncodingFilter = CharacterEncodingFilter()
        characterEncodingFilter.encoding = "UTF-8"
        characterEncodingFilter.setForceEncoding(true)
        return characterEncodingFilter
    }
}