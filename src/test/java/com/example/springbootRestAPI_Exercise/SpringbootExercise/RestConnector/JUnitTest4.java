package com.example.springbootRestAPI_Exercise.SpringbootExercise.RestConnector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitTest4 {
    @Test
    public void testLongerStandardTrue() {
        TitleLengthComparator standardComparator = new StandardComparator();
        String title1 = "Long Long Long Long Long Long Long";
        String title2 = "Short";

        assertTrue(standardComparator.isLonger(title1, title2), "T4.1 - (standard) Title1 should be longer than Title2");
    }

    @Test
    public void testLongerIgnoreTrue() {
        TitleLengthComparator ignoreCaseComparator = new IgnoreCaseComparator();
        String title1 = "Long Long Long Long Long Long Long";
        String title2 = "Short";

        assertTrue(ignoreCaseComparator.isLonger(title1, title2), "T4.2 - (IgnoreCase) Title1 should be longer than Title2");
    }

    @Test
    public void testLongerStandardFalse() {
        TitleLengthComparator standardComparator = new StandardComparator();
        String title1 = "Long Long Long Long Long Long Long";
        String title2 = "Short";

        assertFalse(standardComparator.isLonger(title2, title1), "T4.3 - (Standard) Title2 should not be longer than Title1");
    }

    @Test
    public void testLongerIgnoreFalse() {
        TitleLengthComparator ignoreCaseComparator = new IgnoreCaseComparator();
        String title1 = "Long Long Long Long Long Long Long";
        String title2 = "Short";

        assertFalse(ignoreCaseComparator.isLonger(title2, title1), "T4.4 - (IgnoreCase) Title2 should not be longer than Title1");
    }

    @Test
    public void testLongerStandardEqual() {
        TitleLengthComparator standardComparator = new StandardComparator();
        String title1 = "Equal";
        String title2 = "Short";

        assertFalse(standardComparator.isLonger(title1, title2), "T4.5 - (Standard) Title1 should not be longer than Title2 cuz they are equal");
    }

    @Test
    public void testLongerIgnoreEqual() {
        TitleLengthComparator ignoreCaseComparator = new IgnoreCaseComparator();
        String title1 = "Equal";
        String title2 = "Short";

        assertFalse(ignoreCaseComparator.isLonger(title2, title1), "T4.6 - (IgnoreCase) Title1 should not be longer than Title2 cuz they are equal");
    }
}
