package ru.geekbrains.seminar3.comporators;

import ru.geekbrains.seminar3.models.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    /**
     * Метод сравнения заработных плат сотрудников.
     *
     * @param o1 Первый сотрудник для сравнения
     * @param o2 Второй сотрудник для сравнения
     * @return Возвращает результат проверки:
     * 1, если o1 > o2
     * 0, если o1 == o2
     * -1, если o1 < o2
     */
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
