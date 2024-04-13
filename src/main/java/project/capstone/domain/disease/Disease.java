package project.capstone.domain.disease;

import jakarta.persistence.*;

@Entity
public class Disease {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String treatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosisDisease_id")
    private DiagnosisDisease diagnosisDisease;

}
