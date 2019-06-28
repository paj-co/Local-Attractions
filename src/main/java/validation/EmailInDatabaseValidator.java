package validation;


import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.service.AuthenticationService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailInDatabaseValidator implements ConstraintValidator<EmailInDatabase, String> {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        //if provided email is an empty string, only message should be about empty field
        if (email == null) {
            return true;
        }
        return authenticationService.checkIfUserEmailIsInDatabase(email);
    }

    @Override
    public void initialize(EmailInDatabase constraintAnnotation) {

    }
}
