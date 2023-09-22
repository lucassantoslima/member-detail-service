package ca.bcgeu.validator;

import ca.bcgeu.annotation.PhoneValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<PhoneValidation, String> {

	private static final String PHONE_NUMBER_PATTERN = "(?:\\d{3}-){2}\\d{4}";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			return false;
		}
		return value.matches(PHONE_NUMBER_PATTERN);
	}

}
