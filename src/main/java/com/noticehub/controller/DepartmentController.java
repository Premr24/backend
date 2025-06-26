package com.noticehub.controller;

import com.noticehub.dto.DepartmentDto;
import com.noticehub.dto.FacultyDto;
import com.noticehub.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //REST API to add Department
    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return  new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id,
                                                          @RequestBody DepartmentDto updateDepartment) {

        DepartmentDto departmentDto = departmentService.updateDepartment(id, updateDepartment);
        return ResponseEntity.ok(departmentDto);
    }

    // REST API to get department
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto departmentDto = departmentService
                .getDepartmentById(id);
        return ResponseEntity.ok(departmentDto);
    }

    // REST API to delete department
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Faculty deleted successfully.");
    }
}
