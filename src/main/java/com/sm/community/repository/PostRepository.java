package com.sm.community.repository;

import com.sm.community.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByGroup_GroupIdOrderByCreatedAtDesc(Long groupId);
}
