package com.noticehub.controller;

import com.noticehub.dto.SemesterDto;
import com.noticehub.service.SemesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/semester")
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    //REST API for adding semester
    @PostMapping
    public ResponseEntity<SemesterDto> addSemester(@RequestBody SemesterDto semesterDto) {

        return new ResponseEntity<>(semesterService.addSemester(semesterDto), HttpStatus.CREATED);
    }

    //REST API for updating
    @PutMapping("/{id}")
    public ResponseEntity<SemesterDto> updateSemester(@PathVariable Long id,
                                                      @RequestBody SemesterDto updateSemester) {

        SemesterDto semesterDto = semesterService.updateSemester(id, updateSemester);
        return ResponseEntity.ok(semesterDto);
    }

    //REST API for retrieving
    @GetMapping("/{id}")
    public ResponseEntity<SemesterDto> getSemesterById(@PathVariable Long id) {

        SemesterDto semesterDto = semesterService
                .getSemesterById(id);
        return ResponseEntity.ok(semesterDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSemester(@PathVariable Long id) {

        semesterService.deleteSemester(id);
        return ResponseEntity.ok("Semester deleted successfully.");
    }
}
