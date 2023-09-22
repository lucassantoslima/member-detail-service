package ca.bcgeu.service.impl;

import org.springframework.stereotype.Service;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;
import ca.bcgeu.entity.MemberEmail;
import ca.bcgeu.exception.ErrorCodes;
import ca.bcgeu.exception.NotFoundException;
import ca.bcgeu.mapper.MemberEmailMapper;
import ca.bcgeu.repository.MemberEmailRepository;
import ca.bcgeu.service.MemberEmailService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberEmailServiceImpl implements MemberEmailService {
	
	private final MemberEmailRepository memberEmailRepository;
	private final MemberEmailMapper memberEmailMapper;

	@Override
	public void delete(Long emailId) {
		this.validateMemberEmailNotFound(emailId); 
		this.memberEmailRepository.deleteById(emailId); 
	}
	
	private void validateMemberEmailNotFound(final Long emailId) {
		this.memberEmailRepository.findById(emailId)
		.orElseThrow(() -> new NotFoundException(ErrorCodes.VALIDATE_NOT_FOUND_MEMBER, new Object[] { emailId }));
	}

	@Override
	public void save(MemberEmailRequestDTO memberEmailDTO) {
		MemberEmail newMemberEmail = this.memberEmailMapper.toEntity(memberEmailDTO);
		this.memberEmailRepository.save(newMemberEmail);
	}

	@Override
	public void update(Long emailId, MemberEmailRequestDTO emailDTO) {
		this.memberEmailRepository.findById(emailId).ifPresent(emailToBeUpdated -> {
			emailToBeUpdated.setEmail(emailDTO.getEmail());
			this.memberEmailRepository.save(emailToBeUpdated);
		});
		
	}

}
