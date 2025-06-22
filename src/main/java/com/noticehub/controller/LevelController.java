package com.noticehub.controller;

import com.noticehub.dto.LevelDto;
import com.noticehub.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/level")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    //REST API to add Level
    @PostMapping
    public ResponseEntity<LevelDto> addLevel(@RequestBody LevelDto levelDto){

        return new ResponseEntity<>(levelService.createLevel(levelDto), HttpStatus.CREATED);
    }

    //REST API to update level
    @PutMapping("/update/{id}")
    public ResponseEntity<LevelDto> updateLevel(@PathVariable Long id,
                                                @RequestBody LevelDto updateLevel) {
        LevelDto levelDto = levelService.updateLevel(id, updateLevel);
        return ResponseEntity.ok(levelDto);
    }

    // REST API to get level
    @GetMapping("{id}")
    public ResponseEntity<LevelDto> getLevelById(@PathVariable Long id) {
        LevelDto levelDto = levelService
                .getLevelById(id);
        return ResponseEntity.ok(levelDto);
    }

    //REST API to delete level
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
        return ResponseEntity.ok("Level deleted successfully.");
    }
}
