package org.acme.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DatabaseValidator.class)
@Documented
public @interface DatabaseValidation {
    String message() default "Field Not Exist In Database";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String key() default "";
}
