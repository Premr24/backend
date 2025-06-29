package com.noticehub.service.impl;

import com.noticehub.dto.NoticeDto;
import com.noticehub.entity.Notice;
import com.noticehub.entity.NoticeCategory;
import com.noticehub.entity.NoticePublished;
import com.noticehub.entity.User;
import com.noticehub.exception.ResourceNotFoundException;
import com.noticehub.mapper.NoticeMapper;
import com.noticehub.repository.NoticeCategoryRepository;
import com.noticehub.repository.NoticePublishedRepository;
import com.noticehub.repository.NoticeRepository;
import com.noticehub.repository.UserRepository;
import com.noticehub.service.NoticeService;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NoticeImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;
    private final NoticeCategoryRepository noticeCategoryRepository;
    private final NoticePublishedRepository noticePublishedRepository;

    public NoticeImpl(
            NoticeRepository noticeRepository,
            UserRepository userRepository, NoticeCategoryRepository noticeCategoryRepository,
            NoticePublishedRepository noticePublishedRepository
    ) {
        this.noticeRepository = noticeRepository;
        this.userRepository = userRepository;
        this.noticeCategoryRepository = noticeCategoryRepository;
        this.noticePublishedRepository = noticePublishedRepository;
    }

    @Override
    @Transactional
    public NoticeDto createNotice(NoticeDto noticeDto) {

        if (noticeDto.title() == null || noticeDto.title().isBlank()) {
            throw new IllegalArgumentException("Title is mandatory.");
        }
        if (noticeDto.description() == null || noticeDto.description().isBlank()) {
            throw new IllegalArgumentException("Description is mandatory.");
        }

        // Fetch notice category
        NoticeCategory noticeCategory = noticeCategoryRepository.findById(noticeDto.noticeCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Notice category not found."));

        // Fetch logged-in user's email from Spring Security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        // Find user by email
        User creator = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Logged-in user not found."));


        // Create and save the notice
        Notice notice = Notice.builder()
                .title(noticeDto.title())
                .description(noticeDto.description())
                .file(noticeDto.file())
                .datetime(LocalDateTime.now())
                .noticeCategory(noticeCategory)
                .build();

        Notice savedNotice = noticeRepository.save(notice);

        // Create one entry for the publisher
        NoticePublished published = NoticePublished.builder()
                .notice(savedNotice)
                .user(creator)
                .publishedAt(LocalDateTime.now())
                .build();

        noticePublishedRepository.save(published);

        return NoticeMapper.mapToNoticeDto(savedNotice);
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
