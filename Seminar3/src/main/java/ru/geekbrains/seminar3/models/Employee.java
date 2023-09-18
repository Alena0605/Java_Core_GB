package ru.geekbrains.seminar3.models;

public abstract class Employee implements Comparable<Employee> {
    //region FIELDS

    private int id;                     // ID сотрудника
    private String surname;             // Фамилия сотрудника
    private String name;                // Имя сотрудника
    private int age;                    // Дата рождения сотрудника
    private double salary;              // Зарплата сотрудника
    private static int count = 1000;    // Статическая переменная для подсчета ID сотрудника

    //endregion

    //region CONSTRUCTORS

    /**
     * Конструктор для создания объекта Employee.
     *
     * @param surname Фамилия сотрудника
     * @param name Имя сотрудника
     * @param age Возраст сотрудника
     */
    protected Employee(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    /**
     * Конструктор для создания объекта Employee.
     *
     * @param surname Фамилия сотрудника
     * @param name Имя сотрудника
     * @param age Возраст сотрудника
     * @param salary Зарплата сотрудника
     */
    public Employee(String surname, String name, int age, double salary) {
        this(surname, name, age);
        this.salary = salary;
    }

    {
        id = ++count;
    }

    //endregion

    //region SETTERS AND GETTERS

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int birthday) {
        this.age = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //endregion

    //region PUBLIC METHODS

    /**
     * Абстрактный метод для расчета заработной платы сотрудника.
     *
     * @return Возвращает результат подсчета
     */
    public abstract double calculateSalary();

    /**
     * Метод для сравнения двух сотрудников для последующей сортировки.
     *
     * @param o Объект для сравнения
     * @return Возвращает результат проверки
     */
    @Override
    public int compareTo(Employee o) {
        int res = Double.compare(calculateSalary(), o.calculateSalary());

        if (res == 0) {
            res = getSurname().compareTo(o.getSurname());

            if (res == 0) {
                res = getName().compareTo(o.getName());

                if (res == 0) {
                    res = Integer.compare(getAge(), o.getAge());
                }
            }
        }

        return res;
    }

    /**
     * Вывод на экран информации о сотруднике.
     *
     * @return Возвращает строку с данными по сотруднику
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s %s, Birthday: %d, Salary: %.2f",
                id, surname, name, age, calculateSalary());
    }

    //endregion
}
