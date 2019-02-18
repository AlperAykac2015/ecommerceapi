package com.alper.rest.api.ecommerceapi;

import com.alper.rest.api.ecommerceapi.controller.ProductController;
import com.alper.rest.api.ecommerceapi.model.Product;
import com.alper.rest.api.ecommerceapi.model.ProductList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EcommerceapiApplicationAssuredTests {

	private static final String port = "8080";
	public static final String HTTP_LOCALHOST_8080_PROD_CAR = "http://localhost:8080/prod/car";
	@Autowired
	ProductController productController;


	@Autowired
	private TestRestTemplate restTemplate;



	@Before
	public void setup(){

		Product car = new Product("FIAT","F500","ALPERAYKAC");
		Product car1 = new Product("FIAT","F100","LALEAYKAC");
		Product car2 = new Product("FIAT","F200","AYCAAYKAC");
		Product car3 = new Product("FIAT","F300","ALIAYKAC");
		Product car4 = new Product("FIAT","F400","AYSEAYKAC");
		restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR,car, Product.class);
		restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR,car1, Product.class);
		restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR,car2, Product.class);
		restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR,car3, Product.class);
		restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR,car4, Product.class);
	}


	@Test
	public void contextLoads() {
		assertThat(productController).isNotNull();
		assertThat(restTemplate).isNotNull();
	}

	@Test
	public void getCarsListShouldReturnNonEmptyList() throws Exception {
		ResponseEntity<ProductList> response  = this.restTemplate.getForEntity("http://localhost:" + port + "/prod/products",
				ProductList.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(HTTP_OK);
		assertThat(response.getBody().getProducts().size()).isGreaterThan(0);

	}

	@Test
	public void getAlpersCarShouldReturnCar() throws Exception {

		ParameterizedTypeReference parameterizedTypeReference=		new ParameterizedTypeReference<List<Product>>(){};
		ProductList rtn = this.restTemplate.getForObject("http://localhost:" + port + "/prod/product/FIAT/F500/ALPERAYKAC",
				 ProductList.class );
		System.out.println("--->"+rtn.getProducts().size());
		assertThat(rtn.getProducts().size()).isGreaterThan(0);
	}


}

