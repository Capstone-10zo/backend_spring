package project.capstone.repository.pet;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.capstone.domain.domain.Pet;
import project.capstone.repository.member.MemberRepository;

@Repository
@RequiredArgsConstructor
public class PetRepository {

    private final EntityManager em;
    private final PetJpaRepository petJpaRepository;


}
