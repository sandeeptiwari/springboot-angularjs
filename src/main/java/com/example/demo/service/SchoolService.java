package com.example.demo.service;

import com.example.demo.dto.School;
import com.example.demo.service.impl.ISchoolService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class SchoolService implements ISchoolService {
    private final ObjectMapper objectMapper;
    private List<School> schools;

    public SchoolService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        TypeReference<List<School>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/schools.json");
        try {
            schools = objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<School> getAllSchool() {
        return schools;
    }

    @Override
    public School getSchoolById(Long id) {
        return schools.stream()
                .filter(school -> school.getId() == id)
                .findFirst()
                .orElseGet(School::new);
    }
}
