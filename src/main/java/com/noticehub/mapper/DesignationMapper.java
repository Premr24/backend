package com.noticehub.mapper;

import com.noticehub.dto.DesignationDto;
import com.noticehub.entity.Designation;

public class DesignationMapper {

    public static Designation mapToDesignation(DesignationDto designationDto) {
        return new Designation(
                designationDto.id(),
                designationDto.name()
        );
    }

    public static DesignationDto mapToDesignationDto(Designation designation) {
        return  new DesignationDto(
                designation.getId(),
                designation.getName()
        );
    }
}
