package ca.bcgeu.dto.request;

import ca.bcgeu.annotation.PhoneValidation;
import ca.bcgeu.exception.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberPhoneRequestDTO {

	private Long memberId;
	
	@PhoneValidation(message = ErrorCodes.VALIDATE_FIELD_PHONE)
	private String phone;

}
