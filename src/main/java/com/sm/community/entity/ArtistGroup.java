package com.sm.community.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ArtistGroup {
    @Id @GeneratedValue //기본키 매핑 자동생성
    private Long groupId;

    private String groupName;
    private LocalDate debutDate;
    private String description;
}
