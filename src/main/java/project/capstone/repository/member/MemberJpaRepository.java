package project.capstone.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import project.capstone.domain.domain.Member;


public interface MemberJpaRepository extends JpaRepository<Member, Long> {


}
