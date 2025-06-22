package com.noticehub.service.impl;

import com.noticehub.dto.LevelDto;
import com.noticehub.entity.Level;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.LevelMapper;
import com.noticehub.repository.LevelRepository;
import com.noticehub.service.LevelService;
import org.springframework.stereotype.Service;


import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
public class LevelImpl implements LevelService {

    private final LevelRepository levelRepository;

    public LevelImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    // Add Level method
    @Override
    public LevelDto createLevel(LevelDto levelDto) {

        Level level = LevelMapper.mapToLevel(levelDto);
        Level savedLevel = levelRepository.save(level);
        return LevelMapper.mapToLevelDto(savedLevel);
    }

    //update employee method
    @Override
    public LevelDto updateLevel(Long id, LevelDto updateLevel) {

        Level level = levelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Level not found!"));

        level.setName(updateLevel.name());
        Level update = levelRepository.save(level);

        return new LevelDto(update.getId(), update.getName());
    }

    @Override
    public LevelDto getLevelById(Long id) {

        Level level = levelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Level does not exists!"));
        return LevelMapper.mapToLevelDto(level);
    }

    @Override
    public List<LevelDto> getLevel() {
        return List.of();
    }

    @Override
    public void deleteLevel(Long id) {
        Level level = levelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Level does not exists!"));
        levelRepository.deleteById(id);
    }
}
