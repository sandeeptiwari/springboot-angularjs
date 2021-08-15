package com.example.demo.controller;

import com.example.demo.dto.ClassRoom;
import com.example.demo.service.impl.IClassroomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassRoomController {
    private final IClassroomService classroomService;

    public ClassRoomController(IClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ResponseEntity<List<ClassRoom>> getAllClassrooms() throws IOException {
        return new ResponseEntity(classroomService.getAllClassRoom(), HttpStatus.OK);
    }
}
