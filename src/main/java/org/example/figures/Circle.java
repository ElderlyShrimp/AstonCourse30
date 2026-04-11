package org.example.figures;

public class Circle implements Figure {
    private String colorArea;
    private String colorPerimeter;
    private double radius;

    public Circle(String colorArea, String colorPerimeter, double radius) {
        this.colorArea = colorArea;
        this.colorPerimeter = colorPerimeter;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getSize1() {
        return radius;
    }

    @Override
    public double getSize2() {
        return -1;
    }

    @Override
    public double getSize3() {
        return -1;
    }

    @Override
    public String getPerimeterColor() {
        return colorPerimeter;
    }

    @Override
    public String getAreaColor() {
        return colorArea;
    }
}
