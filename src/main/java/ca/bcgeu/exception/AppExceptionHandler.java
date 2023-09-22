package ca.bcgeu.exception;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ca.bcgeu.dto.response.ErrorMessageDTO;
import ca.bcgeu.dto.response.ErrorMessageDetailDTO;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;

	public AppExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return handleExceptionInternal(ex, createErrorMessage(status, ErrorCodes.VALIDATE_FIELD_INVALID_INPUT,
				ex.getBindingResult().getFieldErrors()), headers, status, request);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleAPIException(final APIException ex, final WebRequest request) {
		return handleExceptionInternal(ex,
				createErrorMessage(ex.getStatus(), ex.getMessage(), null, ex.getParameters()), new HttpHeaders(),
				ex.getStatus(), request);
	}

	private ErrorMessageDTO createErrorMessage(final HttpStatusCode status, final String message,
			final List<FieldError> oErrors, final Object... args) {
		ErrorMessageDTO errorMessage = new ErrorMessageDTO();
		errorMessage.setStatus(status.value());
		errorMessage.setReasonPhrase(status.toString());
		errorMessage.setMessage(getMessage(message, args));

		if (oErrors != null && !oErrors.isEmpty()) {
			errorMessage.setConstraints(createErrorMessageDetails(oErrors));
		}

		return errorMessage;
	}

	private List<ErrorMessageDetailDTO> createErrorMessageDetails(List<FieldError> oErrors) {
		return oErrors.stream().map(this::createErrorMessageDetail).collect(Collectors.toList());
	}

	private ErrorMessageDetailDTO createErrorMessageDetail(FieldError oErrors) {
		return ErrorMessageDetailDTO.builder().field(oErrors.getField())
				.message(getMessage(oErrors.getDefaultMessage(), oErrors.getArguments())).build();
	}

	private String getMessage(String code, Object... args) {
		return this.messageSource.getMessage(code, args, Locale.getDefault());
	}

}
