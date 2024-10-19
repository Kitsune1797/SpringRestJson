package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTest3 {
    @Test
    public void testCalc_Length() {
        PostLengthExpansion postLengthExpansion = new PostLengthExpansion();
        List<Map<String, Object>> testPost = Arrays.asList(
                new HashMap<>(Map.of("title", "Bidibidibaba")),
                new HashMap<>(Map.of("title", "JUnit is a big W"))
        );

        postLengthExpansion.calc_Length(testPost);

        assertEquals(12, testPost.get(0).get("titleLength"));
        assertEquals(16, testPost.get(1).get("titleLength"));
    }

    @Test
    public void testEmpty_Length() {
        PostLengthExpansion postLengthExpansion = new PostLengthExpansion();
        List<Map<String, Object>> testPost = Arrays.asList();

        postLengthExpansion.calc_Length(testPost);

        assertEquals(0, testPost.size());
    }

    @Test
    public void testSpecialChar() {
        PostLengthExpansion postLengthExpansion = new PostLengthExpansion();
        List<Map<String, Object>> testPost = Arrays.asList(
                new HashMap<>(Map.of("title", "You are my special @##*(@&#@^#@(*#"))
        );

        postLengthExpansion.calc_Length(testPost);

        assertEquals(34, testPost.get(0).get("titleLength"));
    }
}
