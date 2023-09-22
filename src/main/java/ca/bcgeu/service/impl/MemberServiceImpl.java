package ca.bcgeu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;
import ca.bcgeu.dto.request.MemberPhoneRequestDTO;
import ca.bcgeu.dto.request.MemberRequestDTO;
import ca.bcgeu.dto.response.MemberResponseDTO;
import ca.bcgeu.entity.Member;
import ca.bcgeu.exception.DuplicateMemberException;
import ca.bcgeu.exception.ErrorCodes;
import ca.bcgeu.exception.NotFoundException;
import ca.bcgeu.mapper.MemberMapper;
import ca.bcgeu.repository.MemberRepository;
import ca.bcgeu.service.MemberEmailService;
import ca.bcgeu.service.MemberPhoneService;
import ca.bcgeu.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	private final MemberEmailService memberEmailService;
	private final MemberPhoneService memberPhoneService;
	private final MemberMapper memberMapper;
	

	@Override
	public MemberResponseDTO findByNumber(String number) {
		return memberMapper.toDTO(this.memberRepository.findByNumber(number)
				.orElseThrow(() -> new NotFoundException(ErrorCodes.VALIDATE_NOT_FOUND_MEMBER, new Object[] { number })));
	}

	@Override
	public List<MemberResponseDTO> findAll() {
		return this.memberRepository.findAll()
									.stream().map(memberMapper::toDTO)
									.toList();
	}
	
	@Override
	public void save(MemberRequestDTO addMemberDTO) {
		this.validateDuplicateMemberByName(addMemberDTO.getName());
		this.validateDuplicateMemberByNumber(addMemberDTO.getNumber());
		
		Member newMember = this.memberMapper.toEntity(addMemberDTO);
		
		this.memberRepository.save(newMember);
	}
	
	@Override
	public void delete(Long memberId) {
		this.validateMemberNotFound(memberId);
		this.memberRepository.deleteById(memberId);
	}
	
	@Override
	public void deleteEmail(Long memberId, Long emailId) {
		this.validateMemberNotFound(memberId);
		this.memberEmailService.delete(emailId);
	}

	@Override
	public void deletePhone(Long memberId, Long phoneId) {
		this.validateMemberNotFound(memberId);
		this.memberPhoneService.delete(phoneId);
	}
	
	@Override
	public void saveEmail(Long memberId, MemberEmailRequestDTO memberEmail) {
		this.validateMemberNotFound(memberId);
		memberEmail.setMemberId(memberId); 
		this.memberEmailService.save(memberEmail); 
	}

	@Override
	public void savePhone(Long memberId, MemberPhoneRequestDTO memberPhone) {
		this.validateMemberNotFound(memberId);
		memberPhone.setMemberId(memberId);
		this.memberPhoneService.save(memberPhone); 
	}

	@Override
	public void updateEmail(Long memberId, Long emailId, MemberEmailRequestDTO emailDTO) {
		this.validateMemberNotFound(memberId);
		this.memberEmailService.update(emailId, emailDTO);
		
	}

	@Override
	public void updatePhone(Long memberId, Long phoneId, MemberPhoneRequestDTO phoneDTO) {
		this.validateMemberNotFound(memberId);
		this.memberPhoneService.update(phoneId, phoneDTO);
	}
	
	private void validateDuplicateMemberByName(String name) {
		this.memberRepository.findByName(name).ifPresent(member -> {
			throw new DuplicateMemberException(ErrorCodes.VALIDATE_RECORD_DUPLICATE_MEMBER, new Object[] { name });
		});
	}
	
	private void validateDuplicateMemberByNumber(String number) {
		this.memberRepository.findByNumber(number).ifPresent(member -> {
			throw new DuplicateMemberException(ErrorCodes.VALIDATE_RECORD_DUPLICATE_MEMBER, new Object[] { number });
		});
	}
	
	private void validateMemberNotFound(final Long memberId) {
		this.memberRepository.findById(memberId)
		.orElseThrow(() -> new NotFoundException(ErrorCodes.VALIDATE_NOT_FOUND_MEMBER, new Object[] { memberId }));
	}


}
