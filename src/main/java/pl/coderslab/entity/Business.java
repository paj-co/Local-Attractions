package pl.coderslab.entity;


import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;
import pl.coderslab.validation.ValidationGroupBusinessChangeData;
import pl.coderslab.validation.ValidationGroupBusinessRegister;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = {ValidationGroupBusinessChangeData.class, ValidationGroupBusinessRegister.class})
    @Email(groups = {ValidationGroupBusinessChangeData.class, ValidationGroupBusinessRegister.class})
    private String email;

    @NotBlank(groups = ValidationGroupBusinessRegister.class)
    //TODO change to min = 8, 1 is for testing
    @Size(min = 1, max = 15, groups = ValidationGroupBusinessRegister.class)
    //TODO @Anotation: password mast contain at least 1 big, 1 small letter, 1 digit, 1 special character
    private String password;

    @NotBlank(groups = ValidationGroupBusinessRegister.class)
    @Transient
    private String repeatPassword;

    @NotBlank(groups = {ValidationGroupBusinessChangeData.class, ValidationGroupBusinessRegister.class})
    private String name;

    //TODO validate NIP i REGON

    @NIP(groups = {ValidationGroupBusinessChangeData.class, ValidationGroupBusinessRegister.class})
    private String nip;
    @REGON(groups = {ValidationGroupBusinessChangeData.class, ValidationGroupBusinessRegister.class})
    private String regon;

    @OneToMany(mappedBy = "business")
    private List<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
