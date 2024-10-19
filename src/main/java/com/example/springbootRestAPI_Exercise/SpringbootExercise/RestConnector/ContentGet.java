package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

public class ContentGet {

    private final static String jsonAPI = "https://jsonplaceholder.typicode.com/posts";
    private final static String emptyjson = "Emptyjson.json";

    public static String getjson() {
        return jsonAPI;
    }

    public static String getEmptyjson() {
        return emptyjson;
    }
}
