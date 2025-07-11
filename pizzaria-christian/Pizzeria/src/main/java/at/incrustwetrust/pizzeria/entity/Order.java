package at.incrustwetrust.pizzeria.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;


@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;
    @CreationTimestamp
    // in our case- same as createdAT
    private Instant deliveredAt;
    @NotNull
    @Column (nullable = false)
    private double total;
    @NotBlank
    @Column (nullable = false)
    private String firstname;
    @NotBlank
    @Column (nullable = false)
    private String surname;
    @NotBlank
    @Column (nullable = false)
    private String phoneNumber;
    @NotBlank
    @Column (nullable = false)
    private String address;
    // can be worldwide - means alphanumeric
    @NotBlank
    @Size(min =2 , max = 10)
    @Column(length = 10, nullable = false)
    private String zipcode;
    @NotBlank
    @Column (nullable = false)
    private String city;
    private String deliveryNote;
    @CreationTimestamp
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "created_by")
    @Schema(hidden = true)
    @JsonIgnore
    private User createdBy;
    // orders can not be manipulated - no updated Timestamps required

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    public Order (){};

    public Order(double total, String firstname, String surname, String phoneNumber, String address, String zipcode, String city, String deliveryNote, User createdBy, List<OrderItem> items) {
        this.total = total;
        this.firstname = firstname;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.deliveryNote = deliveryNote;
        this.createdBy = createdBy;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Instant getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(Instant deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }
    /*
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }*/

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
