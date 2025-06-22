package com.noticehub.controller;

import com.noticehub.dto.FacultyDto;
import com.noticehub.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // REST API to add faculty
    @PostMapping("/create")
    public ResponseEntity<FacultyDto> addFaculty(@RequestBody FacultyDto facultyDto) {

        return new ResponseEntity<>(facultyService.createFaculty(facultyDto), HttpStatus.CREATED);
    }

    // REST API to update faculty
    @PutMapping("/update/{id}")
    public ResponseEntity<FacultyDto> updateFaculty(@PathVariable Long id,
                                                    @RequestBody FacultyDto updateFaculty) {

        FacultyDto facultyDto = facultyService.updateFaculty(id, updateFaculty);
        return ResponseEntity.ok(facultyDto);
    }

    // REST API to get faculty
    @GetMapping("/get/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id) {
        FacultyDto facultyDto = facultyService
                .getFacultyById(id);
        return ResponseEntity.ok(facultyDto);
    }

    // REST API to delete faculty
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok("Faculty deleted successfully.");
    }
}
