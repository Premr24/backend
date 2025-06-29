package com.noticehub.repository;

import com.noticehub.entity.NoticePublished;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticePublishedRepository extends JpaRepository<NoticePublished, Long> {
}
