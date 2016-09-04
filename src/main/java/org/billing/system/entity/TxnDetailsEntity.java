package org.billing.system.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by msahel on 8/22/2016.
 */
@Entity
@Table(name="transaction_details")
@Component
public class TxnDetailsEntity {
    @Id
    @Column(name="product_id",nullable = false,unique = true)
    private Long id;
    @Column(name="product_name")
    private String name;
    private float discount;
    private int quantity;
    @Column(name="total_amount")
    private float totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float description) {
        this.totalAmount = totalAmount;
    }
}
