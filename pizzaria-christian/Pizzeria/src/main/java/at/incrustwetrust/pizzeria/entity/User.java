package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String email;
    private String phoneNumber;
   // private String addressID;
    private boolean isActive;
    private boolean isAdmin;
    // Bild fehlt
    private LocalDateTime created;
    @OneToOne
    private User createdBy;
    private LocalDateTime updated;
    @OneToOne
    private User updateBy;
}
