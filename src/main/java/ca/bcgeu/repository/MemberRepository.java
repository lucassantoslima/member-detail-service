package ca.bcgeu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ca.bcgeu.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	@Query("select m from Member m LEFT JOIN FETCH m.emails e LEFT JOIN FETCH m.phones p where m.number = :number")
	Optional<Member> findByNumber(String number);

	Optional<Member> findByName(String name);

}
