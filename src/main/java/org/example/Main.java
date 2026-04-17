package org.example;

public class Main {
    public static void checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4){
            throw new MyArraySizeException("В массиве не 4 строки");
        }
        for (int i = 0; i < array.length; i++){
            if (array[i].length != 4) {
                throw new MyArraySizeException("В массиве не 4 столбца");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try {
                    int number = Integer.parseInt(array[i][j]);
                    sum += number;
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException("В ячейке [" + i + "] [" + j + "] неверные данные");
                }
            }
        }
        System.out.println("Сумма всех элементов: " + sum);
    }

    public static void catchArrayIndexOutOfBoundsException(){
        try {
            int[][] array2 = {
                    {1, 1, 1},
                    {2, 2, 2}
            };
            int value = array2[0][4];
            System.out.println(value);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Исключение " + e);
        }
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"2", "2", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "3"},
        };

        try {
            checkArray(arr);
            System.out.println("Массив 4х4");
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e){
            System.out.println(e.getMessage());
        }
        catchArrayIndexOutOfBoundsException();
    }
}