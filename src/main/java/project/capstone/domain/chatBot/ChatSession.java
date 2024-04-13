package project.capstone.domain.chatBot;

import jakarta.persistence.*;
import project.capstone.domain.domain.Member;

import java.time.LocalDateTime;

@Entity
public class ChatSession {

    @Id @GeneratedValue
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
