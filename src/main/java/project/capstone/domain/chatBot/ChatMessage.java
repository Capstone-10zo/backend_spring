package project.capstone.domain.chatBot;

import jakarta.persistence.*;
import project.capstone.domain.BaseTimeEntity;
import project.capstone.domain.domain.Member;

import java.time.LocalDateTime;

@Entity
public class ChatMessage extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private Sender sender;

    private String userMessage;
    private String botResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChatSession_id")
    private ChatSession session;

}
