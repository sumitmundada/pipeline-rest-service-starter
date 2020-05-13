# Badge-O-Rama

Badge-O-Rama UI - made with a pinch of Spring REST goodness and a cup of ReactJS.

## Getting Started

These are instructions for using endpoint contracts

### Manual JSON Parsing
JSON can be marshalled/unmarshalled to/from Objects manually using Jackson.  An example of how to implement this using a Visitor object is given below:

```java
package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Date;

public class JacksonParserPOC {

    public static void main(String[] args) {

        // test data
        Visitor source = Visitor.builder()
                .registerDate(new Date())
                .checkedInDate(new Date())
                .checkedOutDate(new Date())
                .phoneNumber("555-555-5555")
                .build();


        // Object --> JSON
        String json = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            json = objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        // JSON --> Object
        Visitor resource = null;
        try {
            resource = objectMapper.readValue(json, Visitor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(resource);
    }
}
```

### REST Endpoint Contracts

