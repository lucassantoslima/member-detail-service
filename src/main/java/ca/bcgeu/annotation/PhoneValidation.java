package ca.bcgeu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ca.bcgeu.validator.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneValidator.class)
public @interface PhoneValidation {

	public String message() default "Invalid email address. Please enter a valid email address in the format example@example.com";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}