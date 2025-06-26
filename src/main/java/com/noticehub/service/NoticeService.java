package com.noticehub.service;

import com.noticehub.dto.NoticeDto;

public interface NoticeService {

    NoticeDto createNotice(NoticeDto noticeDto);

    NoticeDto updateNotice(Long id, NoticeDto noticeDto);

    NoticeDto getNoticeById(Long id);

    void deleteNotice(Long id);
}
