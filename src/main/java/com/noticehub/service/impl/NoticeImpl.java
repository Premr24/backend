package com.noticehub.service.impl;

import com.noticehub.dto.NoticeDto;
import com.noticehub.repository.NoticeRepository;
import com.noticehub.repository.UserRepository;
import com.noticehub.service.NoticeService;

public class NoticeImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    public NoticeImpl(NoticeRepository noticeRepository, UserRepository userRepository) {
        this.noticeRepository = noticeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public NoticeDto createNotice(NoticeDto noticeDto) {
        return null;
    }

    @Override
    public NoticeDto updateNotice(Long id, NoticeDto noticeDto) {
        return null;
    }

    @Override
    public NoticeDto getNoticeById(Long id) {
        return null;
    }

    @Override
    public void deleteNotice(Long id) {

    }
}
