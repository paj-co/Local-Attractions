package pl.coderslab.entity;


import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "businesses")
//TODO żeby nie pisać tych setterów i getterów to można użyć https://projectlombok.org - wówczas adnotacja @Data generuje te metody a z pluginem w InteliJ działa super
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    //TODO @UniqueEmail
//    @UniqueEmail
    @Email
    //TODO każda kolumna bazodanowa powinna mieć adnotację @Column z jej definicją - dzięki temu na bazie zostaną założone faktyczne ograniczenia
    @Column(unique = true, nullable = false, length = 256)
    private String email;

    @NotBlank

    //TODO change to 8, 1 is for testing
    @Size(min = 1)
    //TODO @Anotation: password mast contain aat least 1 big, 1 small letter, 1 digit, 1 special character
    private String password;

    @NotBlank
    private String name;

    //TODO validate NIP i REGON

    @NIP
    private String nip;
    @REGON
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
