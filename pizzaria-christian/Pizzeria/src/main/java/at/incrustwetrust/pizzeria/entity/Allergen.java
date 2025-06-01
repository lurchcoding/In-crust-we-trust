package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;


@Entity
@Table (name = "allergens")
public class Allergen {

   @Id
   // alternative = AllergenTyp
   @Pattern(regexp = "A|B|C|D|E|F|G|H|L|M|N|O|P|R", message = "Ungültiger Allergen-Code")
   private char abbreviation;
   @NotBlank
   @Column (nullable = false)
   private String description;
   @CreationTimestamp
   private Instant createdAt;
   @ManyToOne
   private User createdBy;
   @UpdateTimestamp
   private Instant lastUpdatedAt;
   @ManyToOne
   private User lastUpdatedBy;

   @ManyToMany (mappedBy = "allergens")
   private List<Product> products;

   public Allergen(char abbreviation, String description, User createdBy) {
      this.abbreviation = abbreviation;
      this.description = description;
      this.createdBy = createdBy;
   }

   public char getAbbreviation() {
      return abbreviation;
   }

   public void setAbbreviation(char abbreviation) {
      this.abbreviation = abbreviation;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}



