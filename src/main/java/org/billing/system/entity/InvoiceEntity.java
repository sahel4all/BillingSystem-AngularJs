package org.billing.system.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by msahel on 8/8/2016.
 */
@Entity
@Table(name="Invoice")
@Component
public class InvoiceEntity {

    @Id
    @Column(name = "product_id", unique = true, nullable = false)
    private Long id;
    private String name;
    private String short_name;
    @Column//(name = "product_quantity")
    private int quantity;
    @Column///(name = "product_cost")
    private float buying_cost;
    private float selling_cost;
    private float mrp;
    private float margin_amount;
    private float margin_percentage;
    private float discount;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InvoiceEntity rhs = (InvoiceEntity) obj;
        return new EqualsBuilder().append(id, rhs.id)
                .isEquals();
    }
}
