package org.example.figures;

public interface Figure {
    double getSize1();
    double getSize2();
    double getSize3();

    default double calculatePerimeter(){
        if (getSize3() > 0){
            return getSize1() + getSize2() + getSize3();
        }
        else if (getSize2() > 0){
            return 2 * (getSize2() + getSize1());
        }
        else {
            return 2 * Math.PI * getSize1();
        }
    }

    double getArea();
    String getPerimeterColor();
    String getAreaColor();


    default void infoFigure(String name){
        System.out.println("Фигура: " + name);
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет границ: " + getPerimeterColor());
        System.out.println("Цвет заливки: " + getAreaColor());
        System.out.println();
    }
}
