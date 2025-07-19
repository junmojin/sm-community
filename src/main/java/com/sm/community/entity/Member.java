package com.sm.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ArtistGroup group;

    @Setter
    private String name;

    private LocalDate birthday;
    private String position;
    private String profileImg;

}
