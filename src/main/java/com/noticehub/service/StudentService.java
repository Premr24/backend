package com.noticehub.service;

import com.noticehub.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(UUID.randomUUID().toString(), "James", "Bond", "james@gmail.com"));
        studentList.add(new Student(UUID.randomUUID().toString(), "Henry", "Bond", "henry@gmail.com"));
    }

}
