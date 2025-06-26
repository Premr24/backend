package com.noticehub.service;

import com.noticehub.dto.DesignationDto;

public interface DesignationService {

    DesignationDto addDesignation(DesignationDto designationDto);

    DesignationDto updateDesignation(Long id, DesignationDto updateDesignation);

    DesignationDto getDesignationById(Long id);

    void deleteDesignation(Long id);
}
