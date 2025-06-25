package com.sm.community.controller;
import com.sm.community.dto.PostDto;
import com.sm.community.entity.ArtistGroup;
import com.sm.community.entity.Post;
import com.sm.community.repository.ArtistGroupRepository;
import com.sm.community.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final ArtistGroupRepository groupRepository;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDto dto) {
        ArtistGroup group = groupRepository.findById(dto.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        Post post = new Post();
        post.setGroup(group);
        post.setNickname(dto.getNickname());
        post.setContent(dto.getContent());
        post.setCreated_at(LocalDateTime.now());
        post.setUpdated_at(LocalDateTime.now());

        postRepository.save(post);

        return ResponseEntity.ok("게시글이 등록되었습니다.!!");
    }
}
