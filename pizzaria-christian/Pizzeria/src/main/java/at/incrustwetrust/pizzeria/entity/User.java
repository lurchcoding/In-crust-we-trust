package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class User {

    @Id
    private String userId;
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
    private boolean isActive;
    private boolean isAdmin;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private LocalDateTime latsUpdatedOn;
    @ManyToOne
    private User lastUpdatedBy;

    public User(){
        this.userId = UUID.randomUUID().toString();
    }



    public User( File profilPicture, String username, String password, String firstname, String surname, String email, String phoneNumber, String address, String zipcode, String city, String country, boolean isActive, boolean isAdmin, User createdBy) {
        this.userId = UUID.randomUUID().toString();
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
