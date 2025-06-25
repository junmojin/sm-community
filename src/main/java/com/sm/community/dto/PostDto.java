package com.sm.community.dto;

import lombok.Getter;
import lombok.Setter;

//DTO쓰면 필요없는 필드를 줄이고 가볍게 만들 수 있고, 엔티티에는 DB컬럽,관계 등 민감한 정보가 있어 보안문제로인해 DTO사용
//JPA엔티티와 분리해서 쓰는 데이터 전송 객체 (엔티티는 DB연결용, DTO는 데이터 주고받기용)
@Getter @Setter
public class PostDto {
    private String nickname;
    private String content;
    private Long groupId;
}
