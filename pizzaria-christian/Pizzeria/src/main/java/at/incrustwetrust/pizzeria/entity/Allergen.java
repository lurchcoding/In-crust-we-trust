package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Allergen {

   @Id
   private char abbreviation;
   private String description;

}
