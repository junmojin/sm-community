package com.sm.community.repository;

import com.sm.community.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByGroup_GroupId(Long groupId);
}
