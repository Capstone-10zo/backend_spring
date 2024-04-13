package project.capstone.domain.disease;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import project.capstone.domain.BaseTimeEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Diagnosis extends BaseTimeEntity {

    @Id @GeneratedValue
    private Long id;
    private double confidence;
    private LocalDateTime diagnosisDate;

    @OneToMany(mappedBy = "diagnosis")
    private List<DiagnosisDisease> diagnosisDiseases = new ArrayList<>();
}
