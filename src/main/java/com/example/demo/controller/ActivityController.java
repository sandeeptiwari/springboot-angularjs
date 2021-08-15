package com.example.demo.controller;

import com.example.demo.dto.Activity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityController {
    private final ObjectMapper objectMapper;

    public ActivityController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities() throws IOException {
        TypeReference<List<Activity>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/activities.json");
        List<Activity> activities = objectMapper.readValue(inputStream, typeReference);
        return new ResponseEntity(activities, HttpStatus.OK);
    }


}
