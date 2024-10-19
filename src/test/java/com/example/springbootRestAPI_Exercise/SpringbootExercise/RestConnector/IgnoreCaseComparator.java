package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

public class IgnoreCaseComparator extends TitleLengthComparator{
    @Override
    public boolean isLonger(String title1, String title2) {
        title1 = title1.toLowerCase();
        title2 = title2.toLowerCase();
        boolean result =  title1.length() > title2.length();
        return result;
    }
}
