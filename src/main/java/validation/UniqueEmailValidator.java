package validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.service.AuthenticationService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email != null) {
            System.out.println("isValid 1 " + email + " ------------------------");
            return !authenticationService.checkIfUserEmailIsInDatabase(email);
        }
        return false;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }
}

