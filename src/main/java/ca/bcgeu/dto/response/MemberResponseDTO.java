package ca.bcgeu.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDTO {
	
	private Long id;

	private String name;
	
	private String number;
	
	private List<MemberEmailResponseDTO> emails;
	
	private List<MemberPhoneResponseDTO> phones;
	
}
