package at.incrustwetrust.pizzeria.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Entity
public class Order {

    @Id
    private String OrderId;
    // do we need that - I think yes - so that we know
    //@ManyToOne
    //private User orderedBy;
    @CreationTimestamp
    private LocalDateTime deliveredOn;
    private Double total;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String address;
    // can be worldwide - means alphanumeric
    private String zipcode;
    private String city;
    private String deliveryNotes;
    @ManyToMany
    private ArrayList <Product> orderItem;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @ManyToOne
    private User createdBy;
    // orders can not be manipulated - no updated Timestamps required


}
