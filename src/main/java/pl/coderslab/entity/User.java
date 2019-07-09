package pl.coderslab.entity;

import pl.coderslab.validation.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    //TODO create working annotation UniqueEmail
//    @UniqueEmail
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 3)
    private String password;
    //TODO @Anotation: password mast contain at least 1 big, 1 small letter, 1 digit, 1 special character

    private String nickName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @ManyToMany
    @JoinTable(name = "users_fav_services",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> favouriteServices;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Service> getFavouriteServices() {
        return favouriteServices;
    }

    public void setFavouriteServices(List<Service> favouriteServices) {
        this.favouriteServices = favouriteServices;
    }
}
