package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //Test 1: Check if the number of figures is 1 after adding circle.
    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(10);

        //When
        shapeCollector.addFigure(shape);

        //Then
        Assert.assertEquals(1, shapeCollector.getShapeCollection().size());
    }

    // Test 2: Check if the number of figures is 0 after removing.
    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(10);
        shapeCollector.addFigure(shape);

        //When
        boolean result = shapeCollector.removeFigure(shape);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getShapeCollection().size());
    }

    // Test 3: Remove figure which dose not exist
    @Test
    public void testRemoveFigureNotExisting(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle(10));

        //When
        boolean result = shapeCollector.removeFigure(new Circle(8));

        //Then
        Assert.assertFalse(result);
        Assert.assertEquals(1, shapeCollector.getShapeCollection().size());
    }

    // Test 4: Get first figure
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape = new Circle(10);
        shapeCollector.addFigure(shape);

        //When
        Shape shapeResult = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(shape, shapeResult);
    }

    // Test 5: Get figure if number not exist
    @Test
    public void testGetFigureNotExisting(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle(10));
        shapeCollector.addFigure(new Square(5));

        //When
        Shape shapeResult = shapeCollector.getFigure(8);

        //Then
        Assert.assertNull(shapeResult);
    }

    // Test 6: Get figure if number is negative
    @Test
    public void testGetFigureNegativeNumber(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        Shape shapeResult = shapeCollector.getFigure(-5);

        //Then
        Assert.assertNull(shapeResult);
    }

    // Test 7: Check list of shapes
    @Test
    public void testShowFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape shape =  new Circle(10);
        shapeCollector.addFigure(shape);
        List<Shape> shapeList= new ArrayList<Shape>();
        shapeList.add(shape);

        //When
        List<Shape> shapeResultList = shapeCollector.getShapeCollection();

        //Then
        Assert.assertEquals(shapeList.toString(), shapeResultList.toString());
    }
}
