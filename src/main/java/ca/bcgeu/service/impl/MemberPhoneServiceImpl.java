package ca.bcgeu.service.impl;

import org.springframework.stereotype.Service;

import ca.bcgeu.dto.request.MemberPhoneRequestDTO;
import ca.bcgeu.entity.MemberPhone;
import ca.bcgeu.exception.ErrorCodes;
import ca.bcgeu.exception.NotFoundException;
import ca.bcgeu.mapper.MemberPhoneMapper;
import ca.bcgeu.repository.MemberPhoneRepository;
import ca.bcgeu.service.MemberPhoneService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberPhoneServiceImpl implements MemberPhoneService {

	private final MemberPhoneRepository memberPhoneRepository;
	private final MemberPhoneMapper memberPhoneMapper;

	@Override
	public void delete(Long phoneId) {
		this.validateMemberPhoneNotFound(phoneId);
		this.memberPhoneRepository.deleteById(phoneId);
	}

	@Override
	public void save(MemberPhoneRequestDTO memberPhoneDTO) {
		MemberPhone newMemberPhone = this.memberPhoneMapper.toEntity(memberPhoneDTO);
		this.memberPhoneRepository.save(newMemberPhone);
	}

	private void validateMemberPhoneNotFound(final Long phoneId) {
		this.memberPhoneRepository.findById(phoneId).orElseThrow(
				() -> new NotFoundException(ErrorCodes.VALIDATE_NOT_FOUND_MEMBER, new Object[] { phoneId }));
	}

	@Override
	public void update(Long phoneId, MemberPhoneRequestDTO phoneDTO) {
		this.memberPhoneRepository.findById(phoneId).ifPresent(phoneToBeUpdate -> {
			phoneToBeUpdate.setPhone(phoneDTO.getPhone());
			this.memberPhoneRepository.save(phoneToBeUpdate);
		});
	}

}
