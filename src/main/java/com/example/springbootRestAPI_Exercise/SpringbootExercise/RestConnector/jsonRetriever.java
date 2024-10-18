package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jsonRetriever {
    @RequestMapping("/des1")
    public String getJsonList() {
        return "Hi, I'm getting the Json List";
    }
}
