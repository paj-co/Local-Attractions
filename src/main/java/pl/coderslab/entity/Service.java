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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(File mainPicture) {
        this.mainPicture = mainPicture;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public void setOpenHour(LocalTime openHour) {
        this.openHour = openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(LocalTime closeHour) {
        this.closeHour = closeHour;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<NewsFeed> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<NewsFeed> newsFeed) {
        this.newsFeed = newsFeed;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
