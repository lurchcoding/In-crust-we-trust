package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

// could be an alternative to the current main/subcategory implementation --> store the values in the Database and use them instead of enums
//@Entity
//@Table(name = "categories")
public class Category {

    // in case we go ahead wit this - onetomay relation AND
    //either an ID oder a composite key (mainCategories, subcategory)
    private String mainCategory;
    private String subCategory;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    private User createdBy;
    @UpdateTimestamp
    private Instant lastUpdatedAt;
    @ManyToOne
    private User lastUpdatedBy;

}
