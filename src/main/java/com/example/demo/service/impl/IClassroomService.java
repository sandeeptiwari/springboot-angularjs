package com.example.demo.service.impl;

import com.example.demo.dto.ClassRoom;

import java.io.IOException;
import java.util.List;

public interface IClassroomService {

    List<ClassRoom> getAllClassRoom() throws IOException;

    ClassRoom getClassRoomById(Long id);
}
