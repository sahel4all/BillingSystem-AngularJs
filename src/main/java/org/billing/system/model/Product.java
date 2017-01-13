package org.billing.system.model;

import javax.persistence.Column;

/**
 * Created by msahel on 8/8/2016.
 */
public class Product {

    private Long id;
    private String name;
    private String short_name;
    private int quantity;
    private float buying_cost;
    private float selling_cost;
    private float mrp;
    private float margin_amount;
    private float margin_percentage;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    private float discount;

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

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getBuying_cost() {
        return buying_cost;
    }

    public void setBuying_cost(float buying_cost) {
        this.buying_cost = buying_cost;
    }

    public float getSelling_cost() {
        return selling_cost;
    }

    public void setSelling_cost(float selling_cost) {
        this.selling_cost = selling_cost;
    }

    public float getMrp() {
        return mrp;
    }

    public void setMrp(float mrp) {
        this.mrp = mrp;
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
        return id+ "name: " + name + "short_name: "+ short_name + "quantity: "+ quantity + "buying_cost:"+ buying_cost
                + "selling_cost:"+ selling_cost + "mrp:"+ mrp + "margin_amount:"+ margin_amount + "margin_percentage:"+ margin_percentage;

    }
}
