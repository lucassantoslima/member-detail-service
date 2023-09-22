package ca.bcgeu.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_EMPTY)
public class ErrorMessageDetailDTO {
	
	private String field;
	
	private String message;

	public ErrorMessageDetailDTO(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	

}
