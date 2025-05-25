package at.incrustwetrust.pizzeria.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.File;
import java.time.Instant;
import java.util.List;

@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    private String productName;
    private String productDescription;
    private Double price;
    @Transient
    private File productPicture;
    @ManyToMany
    @JoinTable(
            name = "products_allergens",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "allergene"))
    private List<Allergen> allergens;
    private String mainCategory;
    private String subCategory;
    private boolean isActive;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private Instant lastUpdatedAt;
    @ManyToOne
    private User lastUpdatedBy;





}
