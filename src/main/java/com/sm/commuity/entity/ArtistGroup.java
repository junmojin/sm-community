package com.sm.commuity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ArtistGroup {
    @Id @GeneratedValue //기본키 매핑 자동생성
    private Long group_id;

    private String group_name;
    private LocalDate debut_date;
    private String description;
}
