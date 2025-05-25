package at.incrustwetrust.pizzeria.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemsKey implements Serializable {
    private String orderId;
    private String productId;

}
