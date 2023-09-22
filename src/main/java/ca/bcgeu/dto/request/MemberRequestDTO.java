package ca.bcgeu.dto.request;

import java.util.List;

import ca.bcgeu.dto.response.MemberEmailResponseDTO;
import ca.bcgeu.dto.response.MemberPhoneResponseDTO;
import ca.bcgeu.exception.ErrorCodes;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Add Member Request")
public class MemberRequestDTO {
	
	@Schema(example = "Lucas")
	@NotBlank(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED) 
	private String name;
	
	@Schema(example = "SL123456")
	@NotBlank(message = ErrorCodes.REQUIRED_FIELD_NOT_INFORMED) 
	private String number;
	
	@Valid
	private List<MemberEmailResponseDTO> emails;
	
	@Valid
	private List<MemberPhoneResponseDTO> phones;

}
