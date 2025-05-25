package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;


@Entity
@Table (name = "allergens")
public class Allergen {

   @Id
   private Character abbreviation;
   private String description;
   @CreationTimestamp
   private Instant createdAt;
   @ManyToOne
   private User createdBy;
   @UpdateTimestamp
   private Instant lastUpdatedAt;
   @ManyToOne
   private User lastUpdatedBy;
}
