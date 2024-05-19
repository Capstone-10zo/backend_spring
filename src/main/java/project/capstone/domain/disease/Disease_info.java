package project.capstone.domain.disease;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Disease_info {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    public Disease_info(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
