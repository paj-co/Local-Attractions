package pl.coderslab.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class BusinessChangePassword {

    private Long userId;

    private String email;

    //TODO change to min = 8 after testing
    @Size(min = 1, max = 15)
    private String oldPassword;
    @Size(min = 1, max = 15)
    private String newPassword;
    @Size(min = 1, max = 15)
    private String repeatPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
