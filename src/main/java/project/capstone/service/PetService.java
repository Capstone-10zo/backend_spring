package project.capstone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.capstone.domain.domain.Member;
import project.capstone.domain.domain.Pet;
import project.capstone.repository.member.MemberRepository;
import project.capstone.repository.pet.PetJpaRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {

    private final PetJpaRepository petJpaRepository;
    private final MemberRepository memberRepository;

    public Pet join(Pet pet, Long memberId){
        Pet savedPet = petJpaRepository.save(pet);
        Member findMember = memberRepository.findById(memberId).get();
        savedPet.changeMember(findMember);
        return savedPet;
    }



}
