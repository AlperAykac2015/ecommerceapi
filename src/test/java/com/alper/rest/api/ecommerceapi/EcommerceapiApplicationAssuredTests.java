package com.alper.rest.api.ecommerceapi;

import com.alper.rest.api.ecommerceapi.controller.ProductController;
import com.alper.rest.api.ecommerceapi.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EcommerceapiApplicationAssuredTests {

    private static final String port = "8080";
    public static final String HTTP_LOCALHOST_8080_PROD_CAR = "http://localhost:8080/prod/car";

    @Autowired
    ProductController productController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {

        Product car = new Product("FIAT", "F500", "ALPERAYKAC");
        Product car1 = new Product("FIAT", "F100", "LALEAYKAC");
        Product car2 = new Product("FIAT", "F200", "AYCAAYKAC");
        Product car3 = new Product("FIAT", "F300", "ALIAYKAC");
        Product car4 = new Product("FIAT", "F400", "AYSEAYKAC");
        restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR, car, Product.class);
        restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR, car1, Product.class);
        restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR, car2, Product.class);
        restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR, car3, Product.class);
        restTemplate.postForEntity(HTTP_LOCALHOST_8080_PROD_CAR, car4, Product.class);

    }


    @Test
    public void contextLoads() {
        assertThat(productController).isNotNull();
        assertThat(restTemplate).isNotNull();
    }

    @Test
    public void getCarsListShouldReturnNonEmptyList() throws Exception {
        given().when()
                .get("/prod/products")
                .prettyPeek()
                .then()
                .statusCode(200);
        //.body("profile.username", equalTo(profileData.getUsername()));
    }

    @Test
    public void getAlpersCarShouldReturnCar() throws Exception {

        given().when()
                .get("/prod/products")
                .prettyPeek()
                .then()
                .statusCode(200)
                .assertThat().
                body("ProductList.products.products[0].id", equalTo("1"));
    }


}

