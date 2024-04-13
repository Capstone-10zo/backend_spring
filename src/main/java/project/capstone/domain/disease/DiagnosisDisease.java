package project.capstone.domain.disease;

import jakarta.persistence.*;
import project.capstone.domain.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DiagnosisDisease extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    @OneToMany(mappedBy = "diagnosisDisease")
    private List<Disease> diseases = new ArrayList<>();
}
