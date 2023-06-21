package com.storeapp.store.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;

public class TypeReferenceMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> deserializeJsonStringToList(String s, Class<T> elementClass) throws JsonProcessingException {
        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        return objectMapper.readValue(s, listType);
    }

    public static <T> T deserializeJsonStringToObject(String s, Class<T> elementClass) throws JsonProcessingException {
        JavaType objectType = objectMapper.getTypeFactory().constructType(elementClass);
        return objectMapper.readValue(s, objectType);
    }
}
