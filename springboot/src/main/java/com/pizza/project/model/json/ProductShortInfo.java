package com.pizza.project.model.json;

import java.io.Serializable;

public class ProductShortInfo implements Serializable {
    private Integer productId;
    private Integer id;
    private Integer quantity;

    public ProductShortInfo() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
