package com.sm.community.controller;

import com.sm.community.entity.ArtistGroup;
import com.sm.community.entity.Member;
import com.sm.community.entity.Post;
import com.sm.community.repository.ArtistGroupRepository;
import com.sm.community.repository.MemberRepository;
import com.sm.community.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller//new를 해준다 @Component 포함되어있음.
public class ViewController {

    private final ArtistGroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public ViewController(ArtistGroupRepository groupRepository, MemberRepository memberRepository, PostRepository postRepository) {
        this.groupRepository = groupRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<ArtistGroup> groups = groupRepository.findAll();  // ← 이 줄에서 오류 나면 500이 아닌 404가 날 수 있어요
        model.addAttribute("groups", groups);
        return "index"; // templates/index.html
    }

    @GetMapping("/group/{groupId}")
    public String groupDetail(@PathVariable Long groupId, Model model) {
        ArtistGroup group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("그룹을 찾을 수 없습니다."));

        List<Member> members = memberRepository.findByGroup_GroupId(groupId); //여기서 findBy는 SQL에선 WEHERE문임.
        List<Post> posts = postRepository.findByGroup_GroupIdOrderByCreatedAtDesc(groupId);

        model.addAttribute("group", group);
        model.addAttribute("members", members);
        model.addAttribute("posts", posts);
        return "group";
    }
}

