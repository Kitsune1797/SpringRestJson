package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class PostLengthExpansion {

    @RequestMapping("/des3")
    public List<Map<String, Object>> getJsonExpansion() {
        String requiredAPI = ContentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);
        List<Map<String, Object>> postContent = jsonContent.getBody();

        calc_Length(postContent);

        return postContent;
    }

    public void calc_Length(List<Map<String, Object>> jsonLContent) {
        for (Map<String, Object> currPost : jsonLContent) {
            String currTitle = currPost.get("title").toString();
            int currLength = currTitle.length();
            currPost.put("titleLength", currLength);
        }
    }
}
