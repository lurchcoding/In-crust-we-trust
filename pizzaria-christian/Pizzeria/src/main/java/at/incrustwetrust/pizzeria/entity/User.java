package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.*;


import java.io.File;
import java.time.Instant;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String UserId;
    // File will not be stored in RDB - otherwise it would have to be a Byte Array byte[] imageBytes
    @Transient
    private File profilPicture;
    @NotBlank
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    // can be worldwide - means alphanumeric
    private String zipcode;
    private String city;
    private String country;
    private boolean isActive = true;
    private boolean isAdmin = false;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private Instant lastUpdatedAt;
    @ManyToOne
    private User lastUpdatedBy;

    public User() {
    }

   public User(File profilPicture, String username, String password, String firstname, String surname, String email, String phoneNumber, String address, String zipcode, String city, String country, boolean isActive, boolean isAdmin, User createdBy) {
        this.profilPicture = profilPicture;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.createdBy = createdBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
