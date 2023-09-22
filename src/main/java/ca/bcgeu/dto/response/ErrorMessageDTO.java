package ca.bcgeu.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ErrorMessageDTO {

	  private int status;
	  
	  private String reasonPhrase;
	  
	  private String message;
	  
	  private List<ErrorMessageDetailDTO> constraints;

}

