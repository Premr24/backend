package com.noticehub.mapper;

import com.noticehub.dto.NoticeCategoryDto;
import com.noticehub.entity.NoticeCategory;

public class NoticeCategoryMapper {

    public static NoticeCategory mapToNoticeCategory(NoticeCategoryDto noticeCategoryDto) {
        return new NoticeCategory(
                noticeCategoryDto.id(),
                noticeCategoryDto.name()
        );
    }

    public static NoticeCategoryDto mapToNoticeCategoryDto(NoticeCategory noticeCategory) {
        return new NoticeCategoryDto(
                noticeCategory.getId(),
                noticeCategory.getName()
        );
    }
}
