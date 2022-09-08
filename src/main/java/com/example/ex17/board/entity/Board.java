package com.example.ex17.board.entity;

import com.example.ex17.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    // FetchType 는 무조건 LAZY 타입으로 사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    @Column(nullable = false, length = 128)
    private String title;

    private String content;

    // 연관 관계 매핑
    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }
}
