package com.noticehub.dto;

import java.time.LocalDateTime;

public record NoticeDto(
        Long id,
        String title,
        String description,
        byte[] file,
        LocalDateTime datetime,
        Long noticeCategoryId ) {
}
