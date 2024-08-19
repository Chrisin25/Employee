package com.example.EmployeeDb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.example.EmployeeDb.converters.MongoOffsetDateTimeReader;
import com.example.EmployeeDb.converters.MongoOffsetDateTimeWriter;

import java.util.Arrays;

@Configuration
public class MongoConfig {
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
            new MongoOffsetDateTimeWriter(),
            new MongoOffsetDateTimeReader()
        ));
    }
}

