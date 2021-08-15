package com.example.demo.service;

import com.example.demo.dto.ClassRoom;
import com.example.demo.dto.School;
import com.example.demo.service.impl.IClassroomService;
import com.example.demo.service.impl.ISchoolService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassRoomService implements IClassroomService {

    private final ObjectMapper objectMapper;
    private List<ClassRoom> classRooms;
    private final ISchoolService schoolService;

    public ClassRoomService(ObjectMapper objectMapper, ISchoolService schoolService) {
        this.objectMapper = objectMapper;
        this.schoolService = schoolService;
        TypeReference<List<ClassRoom>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data/classrooms.json");
        try {
            classRooms = objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRooms.stream()
                .map(classRoom -> {
                    School school = schoolService.getSchoolById(classRoom.getSchoolId());
                    classRoom.setSchool(school);
                    return classRoom;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ClassRoom getClassRoomById(Long id) {
        return classRooms.stream()
                .filter(classRoom -> classRoom.getId() == id)
                .map(classRoom -> {
                    School school = schoolService.getSchoolById(classRoom.getSchoolId());
                    classRoom.setSchool(school);
                    return classRoom;
                })
                .findFirst()
                .orElseGet(ClassRoom::new);
    }
}
