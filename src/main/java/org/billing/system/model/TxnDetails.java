package org.billing.system.model;

/**
 * Created by msahel on 8/22/2016.
 */
public class TxnDetails {
    private Long id;
    private String name;
    private int quantity;
    private float discount;
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
