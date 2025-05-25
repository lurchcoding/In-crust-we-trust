package at.incrustwetrust.pizzeria.entity;


import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {

    @Id
    private String productId;
    private String productDescription;
    private Double price;
    private File productPicture;
    @ManyToMany
    private List<Allergen> allergens;
    private String mainCategory;
    private String subCategory;
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
