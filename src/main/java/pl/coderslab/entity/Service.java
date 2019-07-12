package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column(length = 1500000)
    private String mainImage;

    //TODO make annotation -> with pl.coderslab.validation
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
    @NotNull
    @Min(value = 1)
    private Integer houseNumber;
    private Integer apartmentNumber;

    //TODO make @anotation for zip code
    private String zipCode;

    @NotBlank
    @Email
    private String email;

    //TODO make phone @anotation
    private String phone;

    @NotBlank
    @Column(length = 4000)
    @Size(max = 4000)
    private String informations;

//    @NotNull
    private LocalTime openHourMonday;
    //@NotNull
    private LocalTime closeHourMonday;
    //@NotNull
    private LocalTime openHourTuesday;
    //@NotNull
    private LocalTime closeHourTuesday;
    //@NotNull
    private LocalTime openHourWednesday;
    //@NotNull
    private LocalTime closeHourWednesday;
    //@NotNull
    private LocalTime openHourThursday;
    //@NotNull
    private LocalTime closeHourThursday;
    //@NotNull
    private LocalTime openHourFriday;
    //@NotNull
    private LocalTime closeHourFriday;
    //@NotNull
    private LocalTime openHourSaturday;
    //@NotNull
    private LocalTime closeHourSaturday;
    //@NotNull
    private LocalTime openHourSunday;
    //@NotNull
    private LocalTime closeHourSunday;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "services_categories",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "service", cascade = CascadeType.REMOVE)
    private List<Offer> offers;

    @OneToMany(mappedBy = "service", cascade = CascadeType.REMOVE)
    private List<NewsFeed> newsFeed;

    @OneToMany(mappedBy = "service", cascade = CascadeType.REMOVE)
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToMany(mappedBy = "favouriteServices")
    private List<User> users;

    public Service() {
    }

//Getters And Setters ----------------------------------------------------------------------

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

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
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

    public LocalTime getOpenHourMonday() {
        return openHourMonday;
    }

    public void setOpenHourMonday(LocalTime openHourMonday) {
        this.openHourMonday = openHourMonday;
    }

    public LocalTime getCloseHourMonday() {
        return closeHourMonday;
    }

    public void setCloseHourMonday(LocalTime closeHourMonday) {
        this.closeHourMonday = closeHourMonday;
    }

    public LocalTime getOpenHourTuesday() {
        return openHourTuesday;
    }

    public void setOpenHourTuesday(LocalTime openHourTuesday) {
        this.openHourTuesday = openHourTuesday;
    }

    public LocalTime getCloseHourTuesday() {
        return closeHourTuesday;
    }

    public void setCloseHourTuesday(LocalTime closeHourTuesday) {
        this.closeHourTuesday = closeHourTuesday;
    }

    public LocalTime getOpenHourWednesday() {
        return openHourWednesday;
    }

    public void setOpenHourWednesday(LocalTime openHourWednesday) {
        this.openHourWednesday = openHourWednesday;
    }

    public LocalTime getCloseHourWednesday() {
        return closeHourWednesday;
    }

    public void setCloseHourWednesday(LocalTime closeHourWednesday) {
        this.closeHourWednesday = closeHourWednesday;
    }

    public LocalTime getOpenHourThursday() {
        return openHourThursday;
    }

    public void setOpenHourThursday(LocalTime openHourThursday) {
        this.openHourThursday = openHourThursday;
    }

    public LocalTime getCloseHourThursday() {
        return closeHourThursday;
    }

    public void setCloseHourThursday(LocalTime closeHourThursday) {
        this.closeHourThursday = closeHourThursday;
    }

    public LocalTime getOpenHourFriday() {
        return openHourFriday;
    }

    public void setOpenHourFriday(LocalTime openHourFriday) {
        this.openHourFriday = openHourFriday;
    }

    public LocalTime getCloseHourFriday() {
        return closeHourFriday;
    }

    public void setCloseHourFriday(LocalTime closeHourFriday) {
        this.closeHourFriday = closeHourFriday;
    }

    public LocalTime getOpenHourSaturday() {
        return openHourSaturday;
    }

    public void setOpenHourSaturday(LocalTime openHourSaturday) {
        this.openHourSaturday = openHourSaturday;
    }

    public LocalTime getCloseHourSaturday() {
        return closeHourSaturday;
    }

    public void setCloseHourSaturday(LocalTime closeHourSaturday) {
        this.closeHourSaturday = closeHourSaturday;
    }

    public LocalTime getOpenHourSunday() {
        return openHourSunday;
    }

    public void setOpenHourSunday(LocalTime openHourSunday) {
        this.openHourSunday = openHourSunday;
    }

    public LocalTime getCloseHourSunday() {
        return closeHourSunday;
    }

    public void setCloseHourSunday(LocalTime closeHourSunday) {
        this.closeHourSunday = closeHourSunday;
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
