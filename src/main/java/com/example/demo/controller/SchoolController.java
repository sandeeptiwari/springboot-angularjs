package com.example.demo.controller;

import com.example.demo.dto.School;
import com.example.demo.service.impl.ISchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final ISchoolService schoolService;

    public SchoolController(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() throws IOException {
        return new ResponseEntity(schoolService.getAllSchool(), HttpStatus.OK);
    }
}
