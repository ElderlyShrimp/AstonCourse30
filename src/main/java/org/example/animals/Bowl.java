package org.example.animals;

public class Bowl {
    private int foodCount;

    public Bowl(int foodCount) {
        this.foodCount = foodCount;
    }


    public void addFood(int plusFood){
        if (plusFood >= 0){
            foodCount += plusFood;
            System.out.println("Вы добавили " + plusFood + " еды, теперь в миске " + foodCount + " еды");
        }
        else{
            System.out.println("Вы не можете добавить отрицательное количество еды");
        }
    }

    public void takeFood(int amount){
        if (amount < 0){
            System.out.println("Нельзя взять отрицательное количество еды");
        }
        else if (amount > foodCount){
            System.out.println("Недостаточно еды в миске");
        }
        else {
            foodCount -= amount;
        }
    }

    public int getFoodCount() {
        return foodCount;
    }
    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;}
}
