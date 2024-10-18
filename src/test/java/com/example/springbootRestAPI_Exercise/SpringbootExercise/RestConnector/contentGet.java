package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

public class contentGet {

    private final static String jsonAPI = "https://jsonplaceholder.typicode.com/posts";

    public static String getjson() {
        return jsonAPI;
    }
}
