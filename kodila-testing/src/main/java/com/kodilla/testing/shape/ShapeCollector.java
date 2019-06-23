package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeCollection = new ArrayList<Shape>();

    public List<Shape> getShapeCollection() {
        return shapeCollection;
    }

    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape){
        boolean result = false;
        if (shapeCollection.contains(shape)){
            shapeCollection.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int f){
        if(f<shapeCollection.size() && f>=0){
            return shapeCollection.get(f);
        } else {
            System.out.println("In list shapeCollection there is no figure with number: " + f);
            return null;
        }
    }

    public void showFigures(){
        System.out.println(shapeCollection.toString());
    }
}
