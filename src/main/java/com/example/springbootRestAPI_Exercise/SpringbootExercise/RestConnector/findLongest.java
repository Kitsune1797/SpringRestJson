package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class findLongest {
    private String longestTitle = "";
    private String longestTitleBody;


    @RequestMapping("/des2")
    public List<Map<String, Object>> getErrorJsonList() {
        String requiredAPI = contentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);
        List<Map<String, Object>> postContent = jsonContent.getBody();
        calc_Longest(postContent);
        System.out.println("The Content with longest title is");
        System.out.println("Title: " + longestTitle);
        System.out.println("Body: " + longestTitleBody);
        return postContent;
    }

    public void calc_Longest(List<Map<String, Object>> jsonLContent) {
        for (Map<String, Object> currPost : jsonLContent) {
            String currTitle = currPost.get("title").toString();
            if (currTitle.length() > longestTitle.length()) {
                longestTitle = currTitle;
                longestTitleBody = currPost.get("body").toString();
            }
        }
    }
}
