package com.noticehub.mapper;

import com.noticehub.dto.DepartmentDto;
import com.noticehub.entity.Department;

public class DepartmentMapper {

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.id(),
                departmentDto.name()
        );
    }

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName()
        );
    }
}
