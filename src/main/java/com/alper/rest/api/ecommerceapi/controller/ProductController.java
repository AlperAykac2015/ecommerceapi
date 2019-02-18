package com.alper.rest.api.ecommerceapi.controller;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.alper.rest.api.ecommerceapi.model.ProductList;
import com.alper.rest.api.ecommerceapi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prod")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ProductList getProducts() {

        ProductList productList = new ProductList();
        productList.setProducts(productRepository.findAll());
        return productList;
    }

    @GetMapping("/product/{ownerName}")
    ProductList getOwnersProduct(@PathVariable("ownerName") String ownerName) {
        ProductList productList = new ProductList();
        productList.setProducts(productRepository.getProductByOwnerName(ownerName));
        return productList;
    }


    @GetMapping("/product/{name}/{brandName}/{ownerName}")
    ProductList getProduct(@PathVariable("name") String name,@PathVariable("brandName") String brandName,@PathVariable("ownerName") String ownerName) {
        ProductList productList = new ProductList();
        productList.setProducts(productRepository.getProductByNameAndBrandNameAndOwnerName (name,brandName,ownerName));
        return productList;
    }
    @PostMapping("/product/{name}/{brandName}/{ownerName}")
    public void addProduct(@PathVariable("name") String name, @PathVariable("brandName") String brandName, @PathVariable("ownerName") String ownerName) {
        Product product = new Product(name, brandName, ownerName);
        productRepository.saveAndFlush(product);
    }

    @PostMapping("/initdb")
    public void addProduct() {
        System.out.println("---------------------addproduct-------------------");
        Product car0 = new Product("FIAT","F500","ALPERAYKAC");
        Product car1 = new Product("FIAT","F100","LALEAYKAC");
        Product car2 = new Product("FIAT","F200","AYCAAYKAC");
        Product car3 = new Product("FIAT","F300","ALIAYKAC");
        Product car4 = new Product("FIAT","F400","AYSEAYKAC");
        productRepository.saveAndFlush(car0);
        productRepository.saveAndFlush(car1);
        productRepository.saveAndFlush(car2);
        productRepository.saveAndFlush(car3);
        productRepository.saveAndFlush(car4);
    }



}
