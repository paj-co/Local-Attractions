package pl.coderslab.model;

import validation.EmailInDatabase;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ViewMode {

    @Email
    @EmailInDatabase
    private String email;

    @NotBlank
    private String password;

    private String action;


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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
