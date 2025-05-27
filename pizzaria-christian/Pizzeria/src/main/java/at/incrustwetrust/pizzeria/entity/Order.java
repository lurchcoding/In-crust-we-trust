package at.incrustwetrust.pizzeria.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;


@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    @CreationTimestamp
    private Instant deliveredAt;
    private Double total;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String address;
    // can be worldwide - means alphanumeric
    private String zipcode;
    private String city;
    private String deliveryNote;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "created_by")
    // hier geht es darum keine Endlosschleife für die json Rückgabe zu erzeugen
    // @JsonIgnore
    private User createdBy;
       // orders can not be manipulated - no updated Timestamps required


}
