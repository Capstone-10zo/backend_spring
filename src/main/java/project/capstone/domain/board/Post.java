package project.capstone.domain.board;

import jakarta.persistence.*;
import project.capstone.domain.BaseTimeEntity;
import project.capstone.domain.domain.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

}
