package com.alper.rest.api.ecommerceapi.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    public ProductList() {
    }

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
