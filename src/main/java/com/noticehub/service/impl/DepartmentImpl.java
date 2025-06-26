package com.noticehub.service.impl;

import com.noticehub.dto.DepartmentDto;
import com.noticehub.entity.Department;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.DepartmentMapper;
import com.noticehub.repository.DepartmentRepository;
import com.noticehub.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentImpl implements DepartmentService {

    public final DepartmentRepository departmentRepository;

    public DepartmentImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    //add department method
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    //update department method
    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto updateDepartment) {

        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exists!"));

        department.setName(updateDepartment.name());
        Department update = departmentRepository.save(department);
        return new DepartmentDto(update.getId(), update.getName());
    }

    //retrieve department method
    @Override
    public DepartmentDto getDepartmentById(Long id) {

        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exists!"));
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    //delete department method
    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department does not exists!"));
        departmentRepository.deleteById(id);
    }
}
