package ca.bcgeu.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ca.bcgeu.entity.Member;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryUnitTest {

	@Autowired
	MemberRepository employeeRepository;

	@Test
	public void testCreateReadDelete() {
		Member memberRaviEntity = new Member(1l, "Ravi", "BC12345", null, null);

		employeeRepository.save(memberRaviEntity);

		List<Member> findAll = employeeRepository.findAll();
		assertThat(findAll).extracting(Member::getName).containsOnly("Ravi");

		employeeRepository.deleteAll();
		assertThat(employeeRepository.findAll()).isEmpty();
	}
}
