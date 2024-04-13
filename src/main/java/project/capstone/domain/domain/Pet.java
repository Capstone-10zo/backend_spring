package project.capstone.domain.domain;

import jakarta.persistence.*;
import project.capstone.domain.BaseTimeEntity;
import project.capstone.domain.domain.Gender;

@Entity
public class Pet extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String species;
    private String animalType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void changeMember(Member member){
        this.member = member;
        member.getPets().add(this);
    }
}
