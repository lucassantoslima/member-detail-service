package ca.bcgeu.service;

import java.util.List;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;
import ca.bcgeu.dto.request.MemberPhoneRequestDTO;
import ca.bcgeu.dto.request.MemberRequestDTO;
import ca.bcgeu.dto.response.MemberResponseDTO;

public interface MemberService {

	public MemberResponseDTO findByNumber(String number);

	public List<MemberResponseDTO> findAll();
	
	public void save(MemberRequestDTO addMemberDTO);

	public void delete(Long memberId);

	public void deleteEmail(Long memberId, Long emailId);

	public void deletePhone(Long memberId, Long phoneId); 
	
	public void saveEmail(Long memberId, MemberEmailRequestDTO memberEmail);
	
	public void savePhone(Long memberId, MemberPhoneRequestDTO memberPhone);

	public void updateEmail(Long memberId, Long emailId, MemberEmailRequestDTO emailDTO);

	public void updatePhone(Long memberId, Long phoneId, MemberPhoneRequestDTO phoneDTO);  

}
