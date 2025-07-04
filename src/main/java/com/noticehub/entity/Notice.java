package com.noticehub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 500)
    private String description;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] file;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "notice_category_id", nullable = false)
    private NoticeCategory noticeCategory;
}
