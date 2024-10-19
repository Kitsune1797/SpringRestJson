package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JUnitTest1 {

    @Autowired
    private JsonRetriever jsonMain;
    private List<Map<String, Object>> samplePost;

    @BeforeEach
    public void setUp() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        samplePost = objectMapper.readValue(
                new File("src/test/resources/sampleJson.json"),
                new TypeReference<List<Map<String, Object>>>() {}
        );
    }

    @Test
    public void testCallCustomAPI(){
        List<Map<String, Object>> promptedJson  = jsonMain.getJsonList();

        assertNotNull(promptedJson);
        assertEquals(100, promptedJson.size());
    }

    @Test
    public void testCustomJson(){
        List<Map<String, Object>> promptedJson = jsonMain.getJsonList();

        assertNotNull(promptedJson);
        assertEquals(2, samplePost.size());
        assertEquals("J U need test", samplePost.get(0).get("title"));

    }



}
