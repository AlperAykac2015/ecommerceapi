package com.alper.rest.api.ecommerceapi.repo;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.alper.rest.api.ecommerceapi.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductByOwnerName(String ownerName);
    List<Product> getProductByNameAndBrandNameAndOwnerName(String name,String brandName, String owner);
}
