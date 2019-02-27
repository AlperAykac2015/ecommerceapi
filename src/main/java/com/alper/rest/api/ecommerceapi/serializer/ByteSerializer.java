package com.alper.rest.api.ecommerceapi.serializer;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;

public class ByteSerializer extends SerializerProvider {
    @Override
    public WritableObjectId findObjectId(Object o, ObjectIdGenerator<?> objectIdGenerator) {
        return null;
    }

    @Override
    public JsonSerializer<Object> serializerInstance(Annotated annotated, Object o) throws JsonMappingException {
        return null;
    }

    @Override
    public Object includeFilterInstance(BeanPropertyDefinition beanPropertyDefinition, Class<?> aClass) throws JsonMappingException {
        return null;
    }

    @Override
    public boolean includeFilterSuppressNulls(Object o) throws JsonMappingException {
        return false;
    }
}
