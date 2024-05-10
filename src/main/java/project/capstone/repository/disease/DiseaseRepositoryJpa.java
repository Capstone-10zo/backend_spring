package project.capstone.repository.disease;

import org.springframework.data.jpa.repository.JpaRepository;
import project.capstone.domain.disease.Disease_info;

import java.util.Optional;

public interface DiseaseRepositoryJpa extends JpaRepository<Disease_info, Long> {

    public Optional<Disease_info> findByName(String name);
}
