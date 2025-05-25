package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.*;

@Entity
public class orderItems {

    @EmbeddedId
    OrderItemsKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn (name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn  (name = "product_id")
    private Product product;

    private String productName;
    private int quantity;
    // = quantity * price/unit
    private Double price;


}
