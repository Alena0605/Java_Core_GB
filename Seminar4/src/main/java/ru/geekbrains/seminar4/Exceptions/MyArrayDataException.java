package ru.geekbrains.seminar4.Exceptions;

/**
 * Исключение MyArrayDataException выбрасывается, если элемент массива невозможно преобразовать к числу
 */
public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("Ошибка при попытке преобразовать значение в ячейке (" + row + ", " + col + ") в тип int!");
    }
}
