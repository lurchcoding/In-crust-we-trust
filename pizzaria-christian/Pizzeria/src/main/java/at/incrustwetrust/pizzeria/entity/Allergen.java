package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Allergen {

   @Id
   private char abbreviation;
   private String description;
   @CreationTimestamp
   private LocalDateTime createdOn;
   @ManyToOne
   private User createdBy;
   @UpdateTimestamp
   private LocalDateTime latsUpdatedOn;
   @ManyToOne
   private User lastUpdatedBy;
}
