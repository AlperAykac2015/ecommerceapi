package com.alper.rest.api.ecommerceapi;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.alper.rest.api.ecommerceapi.serializer.CustomProductDeserializer;
import com.alper.rest.api.ecommerceapi.serializer.CustomProductSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class EcommerceapiApplicationAssuredTests2 {

    private static final String port = "8080";
    public static final String HTTP_LOCALHOST_8080_PROD_CAR = "http://localhost:8080/prod/car";

    @Before
    public void setup() throws JsonProcessingException {

//        Product car = new Product("FIAT", "F700", "ALIARDAAYKAC");
//        Product car1 = new Product("FIAT", "F100", "LALEAYKAC");
//        Product car2 = new Product("FIAT", "F200", "AYCAAYKAC");
//        Product car3 = new Product("FIAT", "F300", "ALIAYKAC");
//        Product car4 = new Product("FIAT", "F400", "AYSEAYKAC");

//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleModule moduleSerializer =
//                new SimpleModule("CustomProductSerializer", new Version(1, 0, 0, null, null, null));
//        moduleSerializer.addSerializer(Product.class, new CustomProductSerializer());
//        objectMapper.registerModule(moduleSerializer);
//
//        System.out.println("request-mapper:"+objectMapper.writeValueAsString(car));
    }

    public static byte[] toStream(Product product) {
        // Reference for stream of bytes
        byte[] stream = null;
        // ObjectOutputStream is used to convert a Java object into OutputStream
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(product);
            stream = baos.toByteArray();
        } catch (IOException e) {
            // Error in serialization
            e.printStackTrace();
        }
        return stream;
    }

    @Test
    public void createNewCarShouldReturnCREATED() throws Exception {
        Product car = new Product("FIAT", "F700", "ALIARDAAYKAC");
        given().header("content-type", MediaType.APPLICATION_JSON_VALUE)
                .body(car)//objectMapper.writeValueAsString(car))
                .when()
                .post("http://localhost:8080/prod/car")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void getCarsListShouldReturnNonEmptyList() throws Exception {
        given().when()
                .get("/prod/products")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.OK.value());
                //.body("profile.username", equalTo(profileData.getUsername()));
    }

    @Test
    public void getAlpersCarShouldReturnCar() throws Exception {

        given().when()
                .get("/prod/products")
                .prettyPeek()
                .then()
                .statusCode(HttpStatus.OK.value())
                .assertThat()
                .body("ProductList.products.products[1].car_id", equalTo("2"));
    }


}

