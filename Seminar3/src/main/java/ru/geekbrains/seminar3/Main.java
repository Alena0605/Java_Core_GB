package ru.geekbrains.seminar3;

import ru.geekbrains.seminar3.comporators.*;
import ru.geekbrains.seminar3.models.*;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь",
                "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
        String[] surmames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин",
                "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
        Random random = new Random();

        EmployeeList employeeList = new EmployeeList();

        employeeList.addNewEmployee(new Worker(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                43, 80000.0));
        employeeList.addNewEmployee(new Worker(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                25, 40000.0));
        employeeList.addNewEmployee(new Worker(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                37, 64000.0));
        employeeList.addNewEmployee(new Worker(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                51, 150000.0));
        employeeList.addNewEmployee(new Freelancer(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                30, 550.0));
        employeeList.addNewEmployee(new Freelancer(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                26, 520.0));
        employeeList.addNewEmployee(new Freelancer(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                32, 575.0));
        employeeList.addNewEmployee(new Freelancer(surmames[random.nextInt(surmames.length)], names[random.nextInt(names.length)],
                23, 450.0));

        List<Employee> employees = employeeList.getEmployees();

        System.out.println("=========================================================================================");
        System.out.println("СОРТИРОВКА ПО ФАМИЛИИ И ИМЕНИ:");
        System.out.println("=========================================================================================");
        employees.sort(new EmployeeNameComparator());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println();

        System.out.println("=========================================================================================");
        System.out.println("СОРТИРОВКА ПО ВОЗРАСТУ:");
        System.out.println("=========================================================================================");
        employees.sort(new EmployeeAgeComparator());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println();

        System.out.println("=========================================================================================");
        System.out.println("СОРТИРОВКА ПО ЗАРАБОТНОЙ ПЛАТЕ:");
        System.out.println("=========================================================================================");
        employees.sort(new EmployeeSalaryComparator());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println();
    }
}
