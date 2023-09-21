package ru.geekbrains.seminar4;

import ru.geekbrains.seminar4.Models.ArrayMethods;
import ru.geekbrains.seminar4.Exceptions.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Верный массив
        String[][] array1 = new String[][]{{"1", "2", "3", "4"},
                {"9", "8", "7", "6"},
                {"1", "2", "3", "4"},
                {"9", "8", "7", "6"}};

        // Массив с неверным размером
        String[][] array2 = new String[][]{{"1", "2", "3", "4"},
                {"9", "8", "7", "6"},
                {"1", "8", "2", "9"}};

        // Массив с некорректными данными
        String[][] array3 = new String[][]{{"1", null, "3", "4"},
                {"9", "8", "abc", "6"},
                {"1", "@", "3", "4"},
                {"9", "8", "7", "6"}};

        // Массив с неверным размером
        String[][] array4 = new String[][]{{"1", "2", "3", "4"},
                {"9", "8", "7"},
                {"1", "2", "3", "4"},
                {"9", "6"}};

        // Пустой массив
        String[][] array5 = null;

        ArrayMethods getSum = new ArrayMethods();

        try {
            int sum1 = getSum.getSumElements(array1);
            System.out.printf("Сумма элементов в массиве = %d\n", sum1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========================================================");
        System.out.println();

        try {
            int sum2 = getSum.getSumElements(array2);
            System.out.printf("Сумма элементов в массиве = %d\n", sum2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========================================================");
        System.out.println();

        try {
            int sum3 = getSum.getSumElements(array3);
            System.out.printf("Сумма элементов в массиве = %d\n", sum3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========================================================");
        System.out.println();

        try {
            int sum4 = getSum.getSumElements(array4);
            System.out.printf("Сумма элементов в массиве = %d\n", sum4);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========================================================");
        System.out.println();

        try {
            int sum5 = getSum.getSumElements(array5);
            System.out.printf("Сумма элементов в массиве = %d\n", sum5);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=========================================================");
        System.out.println();
    }
}
