package com.noticehub.mapper;

import com.noticehub.dto.LevelDto;
import com.noticehub.entity.Level;

public class LevelMapper {

    //To map LevelDto to Level JP entity
    public static Level mapToLevel(LevelDto levelDto){
        return new Level(
                levelDto.id(),
                levelDto.name()
        );
    }

    //To map Level JP entity to LevelDto
    public static LevelDto mapToLevelDto(Level level){
        return new LevelDto(
                level.getId(),
                level.getName()
        );
    }
}
