package com.kodilla.stream.array;

import org.junit.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int numbers [] = {1,5,8,10,13,15,18,22,25,28,31,40};
        double averageExpected = 18.0;

        //When
        double average = getAverage(numbers);

        //Then
        assertEquals(averageExpected, average, 0.001);
    }
}
