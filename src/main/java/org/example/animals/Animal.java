package org.example.animals;

public abstract class Animal {
    protected static int animalCount;
    protected static int catCount;
    protected static int dogCount;

    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }
    public static int getCatCount() {
        return catCount;
    }
    public static int getDogCount() {
        return dogCount;
    }
    public String getName() {
        return name;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}
