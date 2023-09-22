package ca.bcgeu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bcgeu.entity.MemberEmail;

@Repository
public interface MemberEmailRepository extends JpaRepository<MemberEmail, Long> {

}
