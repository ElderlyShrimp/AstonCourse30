package org.example;

public class Cat extends Animal{
    private boolean satiety;
    public Cat(String name){
        super(name);
        catCount++;
        this.satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200 && distance >= 0) {
            System.out.println(name + " пробежал(а) " + distance + " м.");
        }
        else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }


    public void eating(Bowl bowl, int count){
        if (satiety){
            System.out.println(name + " сыт(а)");
        }
        else {
            if (count < 0){
                System.out.println("Кот не может съесть отрицательное количество еды");
            }
            else if (count <= bowl.getFoodCount()){
                bowl.takeFood(count);
                satiety = true;
                System.out.println(name + " съел(а) " + count + ", в миске осталось " + bowl.getFoodCount() + " еды");
            }
            else {
                System.out.println(name + " не стал(а) есть, еды в миске " + bowl.getFoodCount() + ", а " + name + " хочет съесть " + count);
            }
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}
