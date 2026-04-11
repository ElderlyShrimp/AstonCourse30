package org.example.figures;

public class Triangle implements Figure {
    private String colorArea;
    private String colorPerimeter;
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String colorArea, String colorPerimeter, double sideA, double sideB, double sideC) {
        this.colorArea = colorArea;
        this.colorPerimeter = colorPerimeter;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getSize1() {
        return sideA;
    }

    @Override
    public double getSize2() {
        return sideB;
    }

    @Override
    public double getSize3() {
        return sideC;
    }

    @Override
    public double getArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
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
