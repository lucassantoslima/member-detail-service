package ca.bcgeu.service;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;

public interface MemberEmailService {

	void delete(Long emailId); 
	
	void save(MemberEmailRequestDTO memberEmailDTO);

	void update(Long emailId, MemberEmailRequestDTO emailDTO); 

}
