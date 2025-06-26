package com.noticehub.controller;

import com.noticehub.dto.ProgramDto;
import com.noticehub.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/program")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    // REST API to add program
    @PostMapping
    public ResponseEntity<ProgramDto> createProgram(@RequestBody ProgramDto programDto) {
        return new ResponseEntity<>(programService.createProgram(programDto), HttpStatus.CREATED);
    }

    // REST API to update program
    @PutMapping("{id}")
    public ResponseEntity<ProgramDto> updateProgram(@PathVariable Long id,
                                                    @RequestBody ProgramDto updateProgram) {
        ProgramDto programDto = programService.updateProgram(id, updateProgram);
        return ResponseEntity.ok(programDto);
    }

    // REST API to get program by id
    @GetMapping("/{id}")
    public ResponseEntity<ProgramDto> getProgramById(@PathVariable Long id) {
        ProgramDto programDto = programService.getProgramById(id);
        return ResponseEntity.ok(programDto);
    }

    // REST API to delete program
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
        return ResponseEntity.ok("Program deleted successfully.");
    }
}
