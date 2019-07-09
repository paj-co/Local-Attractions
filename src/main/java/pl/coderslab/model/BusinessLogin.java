package pl.coderslab.model;

import pl.coderslab.validation.BusinessEmailInDatabase;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class BusinessLogin {

    @Email
    @BusinessEmailInDatabase
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
