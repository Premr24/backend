package com.noticehub.controller;

import com.noticehub.dto.TeacherDto;
import com.noticehub.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // REST API to create teacher
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto created = teacherService.createTeacher(teacherDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // REST API to update teacher
    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long id,
                                                    @RequestBody TeacherDto teacherDto) {
        TeacherDto updated = teacherService.updateTeacher(id, teacherDto);
        return ResponseEntity.ok(updated);
    }

    // REST API to get teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id) {
        TeacherDto teacherDto = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacherDto);
    }

    // REST API to delete teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Teacher deleted successfully.");
    }
}
