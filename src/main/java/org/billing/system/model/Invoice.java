package org.billing.system.model;

/**
 * Created by msahel on 8/8/2016.
 */
public class Invoice {

    private Long id;
    private String description;
    private int quantity;
    private float cost;
    private float margin_amount;
    private float margin_percentage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getMargin_amount() {
        return margin_amount;
    }

    public void setMargin_amount(float margin_amount) {
        this.margin_amount = margin_amount;
    }

    public float getMargin_percentage() {
        return margin_percentage;
    }

    public void setMargin_percentage(float margin_percentage) {
        this.margin_percentage = margin_percentage;
    }


    @Override
    public String toString() {
        return id+ "description: " + description + "quantity: "+ quantity + "cost:"+ cost;

    }
}
