package ru.geekbrains.seminar4.Exceptions;

/**
 * Исключение MyArraySizeException выбрасывается, если массив не соответствует установленному размеру
 */
public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("ОШИБКА! Переданный массив не соответствует размеру 4х4.");
    }
}
