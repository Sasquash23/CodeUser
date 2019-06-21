package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.Assert;
import org.junit.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testOddNumbersExterminatorNormalList (){
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        numbersArray.add(5);
        numbersArray.add(12);
        numbersArray.add(18);
        numbersArray.add(25);
        numbersArray.add(36);

        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        oddArray.add(12);
        oddArray.add(18);
        oddArray.add(36);

        //Given
        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();
        //When
        ArrayList<Integer> resultsArray = oddNumbers.exterminate(numbersArray);
        System.out.println(resultsArray);
        //Then
        Assert.assertEquals(resultsArray,oddArray);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList () {
        ArrayList<Integer> empty = new ArrayList<Integer>();
        //Given
        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();
        //When
        ArrayList<Integer> resultsArray = oddNumbers.exterminate(empty);
        System.out.println(empty);
        //Then
        Assert.assertEquals(resultsArray ,empty);
    }




}
