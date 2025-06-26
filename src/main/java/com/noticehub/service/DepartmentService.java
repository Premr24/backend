package com.noticehub.service;

import com.noticehub.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(Long id, DepartmentDto updateDepartment);

    DepartmentDto getDepartmentById(Long id);

    void deleteDepartment(Long id);
}
