package com.noticehub.repository;

import com.noticehub.entity.NoticeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeCategoryRepository extends JpaRepository<NoticeCategory, Long> {
}
