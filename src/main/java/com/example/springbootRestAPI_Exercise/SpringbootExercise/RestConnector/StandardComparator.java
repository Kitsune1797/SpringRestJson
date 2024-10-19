package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

public class StandardComparator extends TitleLengthComparator {

    @Override
    public boolean isLonger(String title1, String title2) {
        boolean result =  title1.length() > title2.length();
        return result;
    }
}
