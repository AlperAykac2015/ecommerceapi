package com.alper.rest.api.ecommerceapi.serializer;

import com.alper.rest.api.ecommerceapi.model.Product;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomProductByteSerializer extends StdSerializer<Product> {

    public CustomProductByteSerializer() {
        this(null);
    }

    public CustomProductByteSerializer(Class<Product> t) {
        super(t);
    }

    @Override
    public void serialize(
            Product product, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("car_brand", product.getBrandName());
        jsonGenerator.writeStringField("car_name", product.getName());
        jsonGenerator.writeStringField("car_owner", product.getOwnerName());
        jsonGenerator.writeStringField("car_id", product.getId().toString());
        jsonGenerator.writeEndObject();


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
}
