package com.noticehub.mapper;

import com.noticehub.dto.NoticeDto;
import com.noticehub.entity.Notice;
import com.noticehub.entity.NoticeCategory;
import com.noticehub.entity.NoticePublished;

public class NoticeMapper {

    public static Notice mapToNotice(NoticeDto dto, NoticeCategory noticeCategory) {
        return Notice.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .file(dto.file())
                .datetime(dto.datetime())
                .noticeCategory(noticeCategory)
                .build();
    }

    public static NoticeDto mapToNoticeDto(Notice notice) {
        return new NoticeDto(
                notice.getId(),
                notice.getTitle(),
                notice.getDescription(),
                notice.getFile(),
                notice.getDatetime(),
                notice.getNoticeCategory().getId()
        );
    }
}
