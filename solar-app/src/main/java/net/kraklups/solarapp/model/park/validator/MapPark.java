package net.kraklups.solarapp.model.park.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MapParkConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MapPark {

	String message() default "{MapPark}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
