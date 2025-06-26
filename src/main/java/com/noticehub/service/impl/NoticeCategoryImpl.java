package com.noticehub.service.impl;

import com.noticehub.dto.NoticeCategoryDto;
import com.noticehub.entity.NoticeCategory;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.NoticeCategoryMapper;
import com.noticehub.repository.NoticeCategoryRepository;
import com.noticehub.service.NoticeCategoryService;
import org.springframework.stereotype.Service;

@Service
public class NoticeCategoryImpl implements NoticeCategoryService {

    public final NoticeCategoryRepository noticeCategoryRepository;

    public NoticeCategoryImpl(NoticeCategoryRepository noticeCategoryRepository) {
        this.noticeCategoryRepository = noticeCategoryRepository;
    }

    //add notice category method
    @Override
    public NoticeCategoryDto createNoticeCategory(NoticeCategoryDto noticeCategoryDto) {

        NoticeCategory noticeCategory = NoticeCategoryMapper.mapToNoticeCategory(noticeCategoryDto);
        NoticeCategory savedNoticeCategory = noticeCategoryRepository.save(noticeCategory);
        return NoticeCategoryMapper.mapToNoticeCategoryDto(noticeCategory);
    }

    //update Notice Category
    @Override
    public NoticeCategoryDto updateNoticeCategory(Long id, NoticeCategoryDto updateNoticeCategory) {

        NoticeCategory noticeCategory = noticeCategoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notice Category does not exists!"));

        noticeCategory.setName(updateNoticeCategory.name());
        NoticeCategory update = noticeCategoryRepository.save(noticeCategory);

        return new NoticeCategoryDto(update.getId(), update.getName());
    }

    //retrieve Notice Category
    @Override
    public NoticeCategoryDto getNoticeCategoryById(Long id) {

        NoticeCategory noticeCategory = noticeCategoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notice Category does not exists!"));
        return NoticeCategoryMapper.mapToNoticeCategoryDto(noticeCategory);
    }

    //delete Notice Category
    @Override
    public void deleteNoticeCategory(Long id) {

        NoticeCategory noticeCategory = noticeCategoryRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notice Category does not exists!"));
        noticeCategoryRepository.deleteById(id);
    }
}
