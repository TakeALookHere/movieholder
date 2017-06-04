package com.miskevich.movieholder.web.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonConverter {

    public static <T> String toJson(List<T> list){
        ObjectMapper objectMapper = new ObjectMapper();

        //I left it only to show that this doesn't help to solve problem with data format after json
//        objectMapper.registerModule(new JSR310Module());
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
