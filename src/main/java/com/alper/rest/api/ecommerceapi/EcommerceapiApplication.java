package com.alper.rest.api.ecommerceapi;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.alper.rest.api.ecommerceapi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.alper.rest.api.ecommerceapi.repo")
public class EcommerceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceapiApplication.class, args);
	}

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
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

