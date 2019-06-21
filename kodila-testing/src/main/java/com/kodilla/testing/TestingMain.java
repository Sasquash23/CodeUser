package com.kodilla.testing;

import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingMain {
    public static void main(String[] args){
        System.out.println("Module 6.2. TDD");
        // Testing SimpleUser
        System.out.println("Testing SimpleUser:");
        //SimpleUser simpleUser = new SimpleUser("theForumUser");
        //String result = simpleUser.getUsername();
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Testing Calculator class
        System.out.println("Testing Calculator class:");
        Calculator simpleCalculator = new Calculator();
        int addResult = simpleCalculator.add(2,4);
        int subResult = simpleCalculator.subtract(10,4);
        if ( (addResult == 6) && (subResult == 6) ) {
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }

        // Testing OddNumbersExterminator class
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        numbersArray.add(5);
        numbersArray.add(12);
        numbersArray.add(18);
        numbersArray.add(20);
        numbersArray.add(35);

        ArrayList<Integer> oddArray = new ArrayList<Integer>();
        oddArray.add(5);
        oddArray.add(35);

        OddNumbersExterminator oddNumbers = new OddNumbersExterminator();
        ArrayList<Integer> resultsArray = oddNumbers.exterminate(numbersArray);
        System.out.println(resultsArray);

    }
}