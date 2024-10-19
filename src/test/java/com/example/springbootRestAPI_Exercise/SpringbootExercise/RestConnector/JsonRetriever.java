package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class JsonRetriever {

    @RequestMapping("/des1")
    public List<Map<String, Object>> getJsonList() {
        String requiredAPI = ContentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);

        return jsonContent.getBody();
    }


}
