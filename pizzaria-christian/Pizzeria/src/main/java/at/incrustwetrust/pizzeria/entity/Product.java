package at.incrustwetrust.pizzeria.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {

    @Id
    private String productId;
    private String porductDescription;
    private double price;
    private File productPicture;
    @ManyToMany
    private ArrayList<Allergen> allergens;
    private String maincategory;
    private String subcategory;
    private boolean isActive;
    private LocalDateTime created;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private LocalDateTime latsUpdatedOn;
    @ManyToOne
    private User lastUpdatedBy;





}
