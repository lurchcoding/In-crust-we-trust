package at.incrustwetrust.pizzeria.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.*;


import java.io.File;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    // File will not be stored in RDB - otherwise it would have to be a Byte Array byte[] imageBytes
    @Transient
    private File profilPicture;
    @NotBlank
    @Column (nullable = false, unique = true)
    @Size(min = 5 , message = "Der Username muss mindestens 5 Zeichen lang sein")
    private String username;
    @NotBlank
    @Column (nullable = false)
    @Size(min = 12 , message = "mindestens 12 Zeichen erforderlich")
    @Pattern(regexp = ".*\\d.*", message = "mindestens eine Zahl erforderlich")
    @Pattern(regexp = ".*[A-Z].*", message = "mindestens eine Grossbuchstabe erforderlich")
    @Pattern(regexp = ".*[a-z].*", message = "mindestens eine Kleinbuchstabe erforderlich")
    @Pattern(regexp = ".*[@$!%*?&].*", message = "mindestens eine Sonderzeichen erforderlich")
    private String password;
    @Enumerated(EnumType.STRING)
    private Salutation salutation;
    @Size(min = 30, message = "Maximale Länge = 30 Zeichen")
    @Column(length = 30)
    private String salutationDetail;
    private String firstname;
    private String surname;
    @Email
    @NotBlank
    @Column (nullable = false, unique = true)
    private String email;
    //todo: maybe add validation
    private String phoneNumber;
    private String address;
    // can be worldwide - means alphanumeric
    @Size(min = 2, max = 10)
    @Column(length = 10)
    private String zipcode;
    private String city;
    private String country;
    private boolean isActive = true;
    private boolean isAdmin = false;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    @Schema(hidden = true)
    private User createdBy;
    @UpdateTimestamp
    private Instant lastUpdatedAt;
    @ManyToOne
    @Schema(hidden = true)
    private User lastUpdatedBy;
    @OneToMany(mappedBy = "createdBy")
    private List<Order> orders;

    public User() {
    }

    public User(File profilPicture, String username, String password, String salutation, String salutationDetail, String firstname, String surname, String email, String phoneNumber, String address, String zipcode, String city, CountryCode countryCode, boolean isActive, boolean isAdmin, User createdBy, List<Order> orders) {
        this.profilPicture = profilPicture;
        this.username = username;
        this.password = password;
        this.salutation = Salutation.valueOf(salutation);
        this.salutationDetail = salutationDetail;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = countryCode.toString();
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.createdBy = createdBy;
        this.orders = orders;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public File getProfilPicture() {
        return profilPicture;
    }

    public void setProfilPicture(File profilPicture) {
        this.profilPicture = profilPicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalutation() {
        return salutation.toString();
    }

    public void setSalutation(String salutation) {
        this.salutation = Salutation.valueOf(salutation);
    }

    public String getSalutationDetail() {
        return salutationDetail;
    }

    public void setSalutationDetail(String salutationDetail) {
        this.salutationDetail = salutationDetail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(CountryCode countryCode) {
        this.country = countryCode.toString();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(User lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
