package at.incrustwetrust.pizzeria.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private String id;
    private String porductDescription;
    @ManyToMany
    private ArrayList<Allergen> allergens;
    private String maincategory;
    private String subcategory;
    private boolean isActive;
    private LocalDateTime created;
    @OneToOne
    private User createdBy;
    private LocalDateTime updated;
    @OneToOne
    private User updateBy;
    //Bild fehlt






}
