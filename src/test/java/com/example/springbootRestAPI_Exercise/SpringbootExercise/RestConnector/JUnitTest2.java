package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitTest2 {
    @Test
    public void testCalcSingle() {
        FindLongest findLongest = new FindLongest();
        List<Map<String, Object>> postList = new ArrayList<>();
        Map<String, Object> testPost = new HashMap<>();
        testPost.put("title", "Test1");
        testPost.put("body", "The body.");
        postList.add(testPost);

        findLongest.calc_Longest(postList);
        assertEquals("Test1", findLongest.getLongestTitle());
        assertEquals("The body.", findLongest.getLongestTitleBody());
    }

    @Test
    public void testCalcDiffLength() {
        FindLongest findLongest = new FindLongest();
        List<Map<String, Object>> postList = new ArrayList<>();
        Map<String, Object> testPost = new HashMap<>();
        testPost.put("title", "Ali");
        testPost.put("body", "This is a Ali.");
        postList.add(testPost);
        testPost.put("title", "Muthu");
        testPost.put("body", "This is a Muthu.");
        postList.add(testPost);
        testPost.put("title", "Ah Cheng");
        testPost.put("body", "This is a Ah Cheng.");
        postList.add(testPost);

        findLongest.calc_Longest(postList);
        assertEquals("Ah Cheng", findLongest.getLongestTitle());
        assertEquals("This is a Ah Cheng.", findLongest.getLongestTitleBody());
    }

    @Test
    public void testCalcEmptyLength() {
        FindLongest findLongest = new FindLongest();
        List<Map<String, Object>> postList = new ArrayList<>();

        findLongest.calc_Longest(postList);
        assertEquals("", findLongest.getLongestTitle());
        assertEquals("", findLongest.getLongestTitleBody());
    }
}
