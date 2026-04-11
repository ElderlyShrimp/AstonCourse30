package org.example.figures;

public class Rectangle implements Figure {
    private String colorArea;
    private String colorPerimeter;
    private double width;
    private double height;

    public Rectangle(String colorArea, String colorPerimeter, double width, double height) {
        this.colorArea = colorArea;
        this.colorPerimeter = colorPerimeter;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getSize1() {
        return width;
    }

    @Override
    public double getSize2() {
        return height;
    }

    @Override
    public double getSize3() {
        return -1;
    }

    @Override
    public double getArea() {
        return width * height;
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
