package pl.coderslab.entity;

import validation.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.File;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    //TODO is picture necessary
    private File mainPicture;

    //TODO make annotation -> with validation
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province; //(in polish: województwo)
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district; //(in polish: powiat)
    @ManyToOne
    @JoinColumn(name = "commune_id")
    private Commune commune; //(in polish: gmina)
    @ManyToOne
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @NotBlank
    private String street;
    @Min(value = 1)
    private Integer houseNumber;
    private Integer apartmentNumber;

    //TODO make @anotation for zip code
    private String zipCode;

    @NotBlank
    @UniqueEmail
    @Email
    private String email;

    //TODO make phone @anotation
    private String phone;

    @NotBlank
    @Column(length = 1000)
    private String informations;

    @NotNull
    private LocalTime openHour;
    @NotNull
    private LocalTime closeHour;

    @ManyToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<Category> categories;

    @OneToMany(mappedBy = "service")
    private List<Offer> offers;

    @OneToMany(mappedBy = "service")
    private List<NewsFeed> newsFeed;

    @OneToMany(mappedBy = "service")
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToMany(mappedBy = "favouriteServices")
    private List<User> users;
}
