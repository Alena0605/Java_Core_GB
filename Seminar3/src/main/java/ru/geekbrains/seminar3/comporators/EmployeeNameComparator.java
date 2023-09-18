package ru.geekbrains.seminar3.comporators;

import ru.geekbrains.seminar3.models.Employee;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {
    /**
     * Метод сравнения сотрудников по фамилии и имени.
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
        int res = o1.getSurname().compareTo(o2.getSurname());
        if (res == 0){
            return o1.getName().compareTo(o2.getName());
        }
        return res;
    }
}
