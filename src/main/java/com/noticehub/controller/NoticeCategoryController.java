package com.noticehub.controller;

import com.noticehub.dto.NoticeCategoryDto;
import com.noticehub.service.NoticeCategoryService;
import org.apache.coyote.Response;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/noticeCategory")
public class NoticeCategoryController {

    public final NoticeCategoryService noticeCategoryService;

    public NoticeCategoryController(NoticeCategoryService noticeCategoryService) {
        this.noticeCategoryService = noticeCategoryService;
    }

    //REST API to add notice category
    @PostMapping
    public ResponseEntity<NoticeCategoryDto> addNoticeCategory(@RequestBody NoticeCategoryDto noticeCategoryDto) {

        return new ResponseEntity<>(noticeCategoryService.createNoticeCategory(noticeCategoryDto), HttpStatus.CREATED);
    }

    //REST API to update notice category
    @PutMapping("/{id}")
    public ResponseEntity<NoticeCategoryDto> updateNoticeCategory(@PathVariable Long id,
                                                                  @RequestBody NoticeCategoryDto updateNoticeCategory) {

        NoticeCategoryDto noticeCategoryDto = noticeCategoryService.updateNoticeCategory(id, updateNoticeCategory);
        return ResponseEntity.ok(noticeCategoryDto);
    }

    //REST API to retrieve notice category
    @GetMapping("/{id}")
    public ResponseEntity<NoticeCategoryDto> getNoticeCategoryById(@PathVariable Long id){

        NoticeCategoryDto noticeCategoryDto = noticeCategoryService
                .getNoticeCategoryById(id);
        return ResponseEntity.ok(noticeCategoryDto);
    }

    //REST API to delete notice category
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedNoticeCategory(@PathVariable Long id) {
        noticeCategoryService.deleteNoticeCategory(id);
        return ResponseEntity.ok("Notice Category deleted successfully.");
    }
}
