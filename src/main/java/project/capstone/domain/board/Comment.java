package project.capstone.domain.board;

import jakarta.persistence.*;
import project.capstone.domain.BaseTimeEntity;
import project.capstone.domain.domain.Member;

import java.time.LocalDateTime;

@Entity
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(length = 255)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
