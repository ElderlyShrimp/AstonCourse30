package org.example;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Миса");
        cat1.run(0);
        cat1.swim(10);

        Cat cat2 = new Cat("Бублик");
        cat2.run(10);

        Dog dog1 = new Dog("Сэм");
        dog1.run(100);
        dog1.swim(50);

        System.out.println("Всего животных создано: " + Animal.getAnimalCount());
        System.out.println("Всего котов создано: " + Animal.getCatCount());
        System.out.println("Всего собак создано: " + Animal.getDogCount());

        Bowl bowl = new Bowl(10);
        cat1.eating(bowl, 12);
        bowl.addFood(10);
        cat1.eating(bowl, 12);

        Cat[] cats = {
            new Cat("Милка"),
            new Cat("Василиса"),
            new Cat("Рыжик"),
            new Cat("Буся"),
            new Cat("Персик")
        };

        int[] foodAmount = {10, 5, 4, 15, 3};

        for (int i = 0; i < cats.length; i++){
            cats[i].eating(bowl, foodAmount[i]);
            System.out.println(cats[i].getName() + (cats[i].isSatiety() ? " сыт(а)" : " голоден(на)"));
        }

        System.out.println();
        System.out.println("_____Задание 2_____");

        Circle circle = new Circle("Красный", "Черный", 5);
        circle.infoFigure("Круг");

        Rectangle rectangle = new Rectangle("Белый", "Синий", 4, 5);
        rectangle.infoFigure("Прямоугольник");

        Triangle triangle = new Triangle("Фиолетовый", "Зеленый", 3, 4, 5);
        triangle.infoFigure("Треугольник");
    }
}