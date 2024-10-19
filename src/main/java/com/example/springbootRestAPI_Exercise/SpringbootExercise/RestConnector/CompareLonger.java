package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class CompareLonger {
    private String longestTitleStandard = "";
    private String longestTitleIgnoreCase = "";
    private Map<String, Object> longestStandardPost = null;
    private Map<String, Object> longestIgnorePost = null;

    @RequestMapping("/des4")
    public String lengthComparation() {
        String requiredAPI = ContentGet.getjson();
        RestTemplate restData = new RestTemplate();
        ResponseEntity<List> jsonContent = restData.getForEntity(requiredAPI, List.class);
        List<Map<String, Object>> postContent = jsonContent.getBody();

        calc_Longest(postContent);
        longestTitleStandard = longestStandardPost.get("title").toString();
        longestTitleIgnoreCase = longestIgnorePost.get("title").toString();

        String result = "<---Length Compare---> \nThe Content with longest title (Standard) is: \nTitle: " + longestTitleStandard +
                " \nThe Content with longest title (IgnoreCase) is: \nTitle: " + longestTitleIgnoreCase;
        System.out.println(result);

        return result;
    }

    public void calc_Longest(List<Map<String, Object>> jsonLContent) {
        for (Map<String, Object> currPost : jsonLContent) {
            if (longestStandardPost == null || longestIgnorePost == null) {
                if (longestStandardPost == null) {
                    longestStandardPost = currPost;
                }

                if (longestIgnorePost == null) {
                    longestIgnorePost = currPost;
                }
            } else {
                TitleLengthComparator standardComparator = new StandardComparator();
                TitleLengthComparator ignoreCaseComparator = new IgnoreCaseComparator();

                longestStandardPost = chooseComparison(standardComparator, longestStandardPost, currPost);
                longestIgnorePost = chooseComparison(ignoreCaseComparator, longestIgnorePost, currPost);
            }
        }
    }

    public Map<String, Object> chooseComparison(TitleLengthComparator comparator, Map<String, Object> longPost, Map<String, Object> currPost) {
        String currTitle = (String) currPost.get("title");
        String longestTitle = longPost.get("title").toString();
        if (comparator.isLonger(currTitle, longestTitle)) {
            return currPost;
        }
        return longPost;
    }
}
