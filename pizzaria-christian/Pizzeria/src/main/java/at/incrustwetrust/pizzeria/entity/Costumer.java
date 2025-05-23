package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;


import java.io.File;
import java.util.UUID;

@Entity
public class Costumer {

    @Id
    private String costumerId;
    //private File profilPicture;
    // @NotBlank
    private String costumerName;
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
  /*  @CreationTimestamp
    private LocalDateTime createdOn;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private LocalDateTime latsUpdatedOn;
    @ManyToOne
    private User lastUpdatedBy;*/

    public Costumer(){
        this.costumerId = UUID.randomUUID().toString();
    }

    public Costumer(String costumerName, String email) {
        this.costumerId = UUID.randomUUID().toString();
        this.costumerName = costumerName;
        this.email = email;
    }

    public Costumer(File profilPicture, String costumerName, String password, String firstname, String surname, String email, String phoneNumber, String address, String zipcode, String city, String country, boolean isActive, boolean isAdmin, Costumer createdBy) {
        this.costumerId = UUID.randomUUID().toString();
        //this.profilPicture = profilPicture;
        this.costumerName = costumerName;
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
       // this.createdBy = createdBy;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String username) {
        this.costumerName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
