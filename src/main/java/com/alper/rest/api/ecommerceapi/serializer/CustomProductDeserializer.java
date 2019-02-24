package com.alper.rest.api.ecommerceapi.serializer;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CustomProductDeserializer extends StdDeserializer<Product> {

    public CustomProductDeserializer() {
        this(null);
    }

    public CustomProductDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Product deserialize(JsonParser parser, DeserializationContext deserializer) {
        Product product = new Product();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
            node = codec.readTree(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try catch block
        JsonNode car_name = node.get("car_name");
        String name = car_name.asText();
        JsonNode car_brand = node.get("car_brand");
        String brand_name = car_brand.asText();
        JsonNode car_owner = node.get("car_owner");
        String owner_name = car_owner.asText();


        product.setName(name);
        product.setBrandName(brand_name);
        product.setOwnerName(owner_name);

        return product;
    }
}