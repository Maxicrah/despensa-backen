package com.maxi.despensa.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Configuration
public class AppConfig {

	//formato pa las fechas
    @Bean
     ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDate.class, new ToStringSerializer());
        mapper.registerModule(module);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }
	
	    // Connect to Angular
	    @Bean
	    WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedOrigins("http://localhost:4200")
	                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                        .allowedHeaders("*");
	            }

	            @Override
	            public void addResourceHandlers(ResourceHandlerRegistry registry) {
	                registry.addResourceHandler("/media/**")
	                        .addResourceLocations("file:mediafiles/");
	            }
	        };
	    }
	}