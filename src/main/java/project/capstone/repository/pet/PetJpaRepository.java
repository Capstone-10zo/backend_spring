package project.capstone.repository.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import project.capstone.domain.domain.Pet;

import java.util.List;

public interface PetJpaRepository extends JpaRepository<Pet, Long> {
    List<Pet> findBySpecies(String species);
}
