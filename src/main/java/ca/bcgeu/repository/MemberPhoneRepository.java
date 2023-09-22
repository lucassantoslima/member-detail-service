package ca.bcgeu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bcgeu.entity.MemberPhone;

@Repository
public interface MemberPhoneRepository extends JpaRepository<MemberPhone, Long> {

}
