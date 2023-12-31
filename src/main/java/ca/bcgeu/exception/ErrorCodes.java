package ca.bcgeu.exception;

public interface ErrorCodes {

	String REQUIRED_FIELD_NOT_INFORMED = "requiredField.not.informed";

	String VALIDATE_FIELD_MAX_LENGTH = "validateField.max.length";

	String VALIDATE_FIELD_MIN_LENGTH = "validateField.min.length";

	String VALIDATE_FIELD_INVALID_RANGE = "validateField.invalid.length";

	String VALIDATE_RECORD_ALREADY_REGISTERED = "validateRecord.already.registered";

	String VALIDATE_FIELD_INVALID_PATTERN = "validateField.invalid.pattern";

	String VALIDATE_FIELD_INVALID_INPUT = "validateField.invalid.input";
	
	String VALIDATE_RECORD_DUPLICATE_MEMBER = "validate.duplicate.member";
	
	String VALIDATE_FIELD_EMAIL = "validateField.invalid.email";
	
	String VALIDATE_FIELD_PHONE = "validateField.invalid.phone";
	
	String VALIDATE_NOT_FOUND_MEMBER = "validate.not.found.member";
	
}
