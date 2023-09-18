package ru.geekbrains.seminar3.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeList implements Iterable<Employee> {
    //region FIELDS

    private final List<Employee> employees;       // Список сотрудников

    //endregion

    //region CONSTRUCTORS

    /**
     * Конструктор для создания объекта EmployeeList - списка, в который будут добавляться сотрудники.
     */
    public EmployeeList() {
        employees = new ArrayList<>();
    }

    //endregion

    //region GETTERS AND SETTERS

    public List<Employee> getEmployees() {
        return employees;
    }

    //endregion

    //region PUBLIC METHODS

    /**
     * Метод добавления сотрудника в список.
     *
     * @param employee Сотрудник
     */
    public void addNewEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Метод для перебора сотрудников в цикле foreach.
     *
     * @return Переход на следующий шаг
     */
    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }

    //endregion
}
