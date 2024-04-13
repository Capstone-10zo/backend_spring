package project.capstone.domain.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.capstone.domain.BaseTimeEntity;
import project.capstone.domain.board.Post;
import project.capstone.domain.domain.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String loginId;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Pet> pets = new ArrayList<>();

}
