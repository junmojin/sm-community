package com.sm.community.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id @GeneratedValue
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ArtistGroup group;

    private String nickname;
    private String password;

    @Lob
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
}
