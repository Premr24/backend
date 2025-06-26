package com.noticehub.service.impl;

import com.noticehub.dto.DesignationDto;
import com.noticehub.entity.Designation;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.DesignationMapper;
import com.noticehub.repository.DesignationRepository;
import com.noticehub.service.DesignationService;
import org.springframework.stereotype.Service;

@Service
public class DesignationImpl implements DesignationService {

    public final DesignationRepository designationRepository;

    public DesignationImpl(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    //Add designation method
    @Override
    public DesignationDto addDesignation(DesignationDto designationDto) {

        Designation designation = DesignationMapper.mapToDesignation(designationDto);
        Designation savedDesignation = designationRepository.save(designation);
        return DesignationMapper.mapToDesignationDto(savedDesignation);
    }

    //update designation method
    @Override
    public DesignationDto updateDesignation(Long id, DesignationDto updateDesignation) {

        Designation designation = designationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Designation does not exists!"));

        designation.setName(updateDesignation.name());
        Designation update = designationRepository.save(designation);
        return new DesignationDto(update.getId(), update.getName());
    }

    //retrieve designation method
    @Override
    public DesignationDto getDesignationById(Long id) {

        Designation designation = designationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Designation does not exists!"));
        return DesignationMapper.mapToDesignationDto(designation);
    }

    //delete designation method
    @Override
    public void deleteDesignation(Long id) {
        Designation designation = designationRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Designation deleted successfully."));
        designationRepository.deleteById(id);
    }
}
