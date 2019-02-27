package com.alper.rest.api.ecommerceapi.serializer;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomProductSerializer extends StdSerializer<Product> {

    public CustomProductSerializer() {
        this(null);
    }

    public CustomProductSerializer(Class<Product> t) {
        super(t);
    }

    @Override
    public void serialize(
            Product product, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("car_brand", product.getBrandName());
        jsonGenerator.writeStringField("car_name", product.getName());
        jsonGenerator.writeStringField("car_owner", product.getOwnerName());
//        jsonGenerator.writeStringField("car_id", product.getId().toString());
        jsonGenerator.writeEndObject();
    }
}
