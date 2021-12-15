package com.example.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // logic of the annotation
@Target({ElementType.METHOD, ElementType.FIELD}) // can use annotation for both method and field
@Retention(RetentionPolicy.RUNTIME)  // keep this for runtime
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";  // if they don't pass value the default will be LUV

    // define default error message
    public String message() default "Must start with LUV";  // if they don't pass value for message the default is this

    // define default groups (group validation related constrains together)
    public Class<?>[] groups() default {};

    // define default payload (additional information about the validation error that occurs)
    public Class<? extends Payload>[] payload() default {};

}
