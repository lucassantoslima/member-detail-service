package ca.bcgeu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.CONFLICT)//409
public class DuplicateMemberException extends APIException {
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateMemberException(final String msg) {
		super(HttpStatus.CONFLICT, msg);
	}
	
	public DuplicateMemberException(final String msg, final Object[] parameters) {
		super(HttpStatus.CONFLICT, msg, parameters);
	}
	
}
