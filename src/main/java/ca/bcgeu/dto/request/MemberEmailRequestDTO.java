package ca.bcgeu.dto.request;

import ca.bcgeu.exception.ErrorCodes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEmailRequestDTO {
	
	private Long memberId;
	
	@Email(message = ErrorCodes.VALIDATE_FIELD_EMAIL, regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@NotEmpty(message = ErrorCodes.VALIDATE_FIELD_INVALID_INPUT)
	private String email;
	
}
