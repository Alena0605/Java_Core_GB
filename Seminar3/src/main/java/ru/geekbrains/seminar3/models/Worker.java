package ru.geekbrains.seminar3.models;

public class Worker extends Employee {
    //region CONSTRUCTORS

    /**
     * Конструктор для создания объекта Worker.
     *
     * @param surname Фамилия сотрудника
     * @param name Имя сотрудника
     * @param age Возраст сотрудника
     * @param salary Зарплата сотрудника
     */
    public Worker(String surname, String name, int age, double salary) {
        super(surname, name, age, salary);
    }

    //endregion

    //region PUBLIC METHODS

    /**
     * Расчет заработной платы сотрудника.
     *
     * @return Возвращает значение
     */
    @Override
    public double calculateSalary() {
        return getSalary();
    }

    /**
     * Вывод на экран информации о сотруднике Worker.
     *
     * @return Возвращает строку с данными по сотруднику
     */
    @Override
    public String toString() {
        return String.format("WORKER:\n%s", super.toString());
    }

    //endregion
}
