package com.noticehub.service;

import com.noticehub.dto.LevelDto;

import java.util.List;

public interface LevelService {

    LevelDto createLevel(LevelDto levelDto);

    LevelDto updateLevel(Long id, LevelDto updateLevel);

    LevelDto getLevelById(Long id);

    LevelDto getLevelByName(String name);

    List<LevelDto> getLevel();

    void deleteLevel(Long id);
}
