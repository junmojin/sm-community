package com.sm.community.controller;
import com.sm.community.dto.PostDto;
import com.sm.community.entity.ArtistGroup;
import com.sm.community.entity.Post;
import com.sm.community.repository.ArtistGroupRepository;
import com.sm.community.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final ArtistGroupRepository groupRepository;

    @PostMapping
    public String createPost(PostDto dto, Model model) {
        ArtistGroup group = groupRepository.findById(dto.getGroupId())
                .orElseThrow(() -> new RuntimeException("그룹을 찾지 못했습니다."));

        Post post = new Post();
        post.setGroup(group);
        post.setNickname(dto.getNickname());
        post.setContent(dto.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        postRepository.save(post);
        return "redirect:/";
        //return ResponseEntity.ok("게시글이 등록되었습니다.!!");
    }
}
