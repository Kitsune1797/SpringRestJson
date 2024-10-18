package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

public class contentGet {

    private final static String jsonAPI = "https://jsonplaceholder.typicode.com/posts";
    private final static String emptyjson = "emptyjson.json";

    public static String getjson() {
        return jsonAPI;
    }

    public static String getEmptyjson() {
        return emptyjson;
    }
}
