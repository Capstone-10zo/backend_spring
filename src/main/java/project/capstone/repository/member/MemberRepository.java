package project.capstone.repository.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.capstone.domain.domain.Member;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    private final EntityManager em;

    public void save(Member member){
        memberJpaRepository.save(member);
    }

    public void update(Member member){

    }

    public Optional<Member> findById(Long memberId){
        return memberJpaRepository.findById(memberId);
    }

    public List<Member> findAll(){
        return memberJpaRepository.findAll();
    }

    public void delete(Long memberId){
        memberJpaRepository.deleteById(memberId);
    }
}
