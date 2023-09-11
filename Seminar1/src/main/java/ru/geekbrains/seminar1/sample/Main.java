package ru.geekbrains.seminar1.sample;

import ru.geekbrains.seminar1.regular.Decorator;
import ru.geekbrains.seminar1.regular.OtherClass;

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 */
public class Main {
    /**
     * Точка входа в программу. С неё всегда всё начинается.
     *
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        int result = OtherClass.add(24, 12);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.sub(24, 12);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.mul(24, 12);
        System.out.println(Decorator.decorate(result));
        result = OtherClass.div(24, 12);
        System.out.println(Decorator.decorate(result));
    }
}
