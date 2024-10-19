package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class JsonRetriever {

    //Temporary leaving here for future exception enhancement, decide soon after further testing
//    @RequestMapping("/des1")
//    public ResponseEntity<?> getJsonList() {
//        try {
//            String requiredAPI = contentGet.getjson();
//            RestTemplate restData = new RestTemplate();
//            ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);
//            return ResponseEntity.ok(jsonContent);
//
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Error while accessing the API: " + e.getMessage());
//        }
//    }
    @RequestMapping("/des1")
    public List<Map<String, Object>> getJsonList() {
        String requiredAPI = ContentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);

        return jsonContent.getBody();
    }


}
