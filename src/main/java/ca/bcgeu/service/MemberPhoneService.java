package ca.bcgeu.service;

import ca.bcgeu.dto.request.MemberPhoneRequestDTO;

public interface MemberPhoneService {

	void delete(Long phoneId); 
	
	void save(MemberPhoneRequestDTO memberEmailDTO);

	void update(Long phoneId, MemberPhoneRequestDTO phoneDTO); 

}
