package com.sm.community.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ArtistGroup group;

    private String name;
    private LocalDate birthday;
    private String position;
    private String profileImg;

}
