package validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BusinessEmailInDatabaseValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessEmailInDatabase {

    String message() default "{emailInDatabase.error.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

