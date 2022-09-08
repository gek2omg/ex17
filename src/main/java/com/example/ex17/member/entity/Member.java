package com.example.ex17.member.entity;

import com.example.ex17.board.entity.Board;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = true, length = 13)
    private String jumin;

    private String address;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
