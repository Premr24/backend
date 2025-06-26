package com.noticehub.service;

import com.noticehub.dto.NoticeCategoryDto;

public interface NoticeCategoryService {

    NoticeCategoryDto createNoticeCategory(NoticeCategoryDto noticeCategoryDto);

    NoticeCategoryDto updateNoticeCategory(Long id, NoticeCategoryDto updateNoticeCategory);

    NoticeCategoryDto getNoticeCategoryById(Long id);

    void deleteNoticeCategory(Long id);
}
