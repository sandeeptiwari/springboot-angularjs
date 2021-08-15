package com.example.demo.service.impl;

import com.example.demo.dto.ClassRoom;
import com.example.demo.dto.School;

import java.util.List;

public interface ISchoolService {

    List<School> getAllSchool();

    School getSchoolById(Long id);
}
