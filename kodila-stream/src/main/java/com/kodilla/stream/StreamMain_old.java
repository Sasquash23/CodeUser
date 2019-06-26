package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.stream.Collectors;

public class StreamMain_old {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        SaySomething saySomething = new SaySomething();
        saySomething.say();

        System.out.println("### 2 ### \nSimpler way to print text.");

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        //Lambda example
        /*Processor processor2 = new Processor();
        Executor codeToExecute = () -> System.out.println("### 4 ### \nThis is an example text with lambda usage.");
        processor2.execute(codeToExecute);*/
        processor.execute(() -> System.out.println("### 4 ### \nThis is an example text."));

        //Examples of usage lambda expressions
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("\nText beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifierText = poemBeautifier.beautify("Text to beautify", (text -> text.toUpperCase()));
        System.out.println(beautifierText);
        System.out.println(poemBeautifier.beautify("Text to beautify", (text -> text.toLowerCase())).toString());
        System.out.println(poemBeautifier.beautify("Text to beautify", (text -> "Start: " + text + "...End")).toString());
        System.out.println(poemBeautifier.beautify("Text to beautify", (text -> text.replace(" ", "_"))).toString());
        System.out.println(poemBeautifier.beautify("Text to beautify", (text -> "Text has " + text.length() + " letters ->" + text )).toString());
        System.out.println(poemBeautifier.beautify("Text to beautify", (text -> text.concat(String.valueOf(text.hashCode())))).toString());

        String beautifierText2 = poemBeautifier.beautify("Text to beautify", (text -> text.chars()
                .mapToObj(textToChar -> String.valueOf((char) textToChar))
                .collect(Collectors.joining("/\\"))
        ));
        System.out.println(beautifierText2);

        //System.out.println("Using Stream to generate even numbers from 1 to 20");
        //NumbersGenerator.generateEven(20);
    }
}