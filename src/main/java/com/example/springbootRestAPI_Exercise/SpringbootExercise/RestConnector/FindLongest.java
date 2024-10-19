package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class FindLongest {
    private String longestTitle = "";
    private String longestTitleBody = "";

    public String getLongestTitle() {
        return longestTitle;
    }

    public String getLongestTitleBody() {
        return longestTitleBody;
    }

    @RequestMapping("/des2")
    public String getLongest() {
        String requiredAPI = ContentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);
        List<Map<String, Object>> postContent = jsonContent.getBody();

        calc_Longest(postContent);

        String result = "<---Find Longest Title---> \nThe Content with longest title is \nTitle: " + longestTitle + " \nBody: " + longestTitleBody;
        System.out.println(result);
        return result;
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
