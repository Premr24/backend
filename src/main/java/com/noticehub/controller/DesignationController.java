package com.noticehub.controller;

import com.noticehub.dto.DesignationDto;
import com.noticehub.service.DesignationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/designation")
public class DesignationController {

    public final DesignationService designationService;

    public DesignationController(DesignationService designationService) {
        this.designationService = designationService;
    }

    // REST API to add designation
    @PostMapping
    public ResponseEntity<DesignationDto> addDesignation(@RequestBody DesignationDto designationDto) {

        return new ResponseEntity<>(designationService.addDesignation(designationDto), HttpStatus.CREATED);
    }

    //REST API to update designation
    @PutMapping("/{id}")
    public ResponseEntity<DesignationDto> updateDesignation(@PathVariable Long id,
                                                            @RequestBody DesignationDto updateDesignation) {

        DesignationDto designationDto = designationService.updateDesignation(id, updateDesignation);
        return ResponseEntity.ok(designationDto);
    }

    //REST API to get designation
    @GetMapping("/{id}")
    public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long id) {

        DesignationDto designationDto = designationService
                .getDesignationById(id);
        return ResponseEntity.ok(designationDto);
    }

    //REST API to delete designation
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteDesignation(@PathVariable Long id) {

        designationService.deleteDesignation(id);
        return ResponseEntity.ok("Designation deleted successfully.");
    }
}
