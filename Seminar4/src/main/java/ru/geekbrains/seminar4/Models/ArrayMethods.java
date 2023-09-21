package ru.geekbrains.seminar4.Models;

import ru.geekbrains.seminar4.Exceptions.*;

public class ArrayMethods {
    /**
     * Метод для получения суммы всех элементов в массиве.
     *
     * @param array Двумерный строковый массив
     * @return Возвращает сумму элементов
     * @throws Exception Выбрасывает исключения MyArrayDataException и MyArraySizeException
     */
    public int getSumElements(String[][] array) throws Exception {
        if (array == null) {
            throw new MyArraySizeException();
        }

        printArray(array);

        int sum = 0;
        int arrayLen = array.length;

        if (arrayLen == 4) {
            for (int row = 0; row < arrayLen; row++) {
                if (array[row].length == 4) {
                    for (int col = 0; col < array[row].length; col++) {
                        if (isNumeric(array[row][col])) {
                            sum += Integer.parseInt(array[row][col]);
                        } else {
                            throw new MyArrayDataException(row, col);
                        }
                    }
                } else {
                    throw new MyArraySizeException();
                }
            }
        } else {
            throw new MyArraySizeException();
        }

        return sum;
    }

    /**
     * Метод проверки элемента массива на преобразование в число.
     *
     * @param s Элемент массива
     * @return Возвращает булевое значение - удалось преобразование (true) или нет (false)
     */
    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Метод печати массива.
     *
     * @param array Строковый двумерный массив
     */
    public void printArray(String[][] array) {
        for (String[] row : array) {
            for (String value : row) {
                System.out.printf("%-5s", value);
            }
            System.out.println();
        }
    }
}
