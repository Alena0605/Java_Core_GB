package ru.geekbrains.seminar3.models;

public class Freelancer extends Employee {
    //region FIELDS

    private static final double WORK_DAYS_PER_MONTH = 20.8;     // Количество рабочих дней в месяце
    private static final double WORK_HOURS_PER_DAY = 8;         // Количество рабочих часов в день
    private double hourlyRate;                                  // Почасовая ставка

    //endregion

    //region CONSTRUCTORS

    /**
     * Конструктор для создания объекта Freelancer.
     *
     * @param surname Фамилия сотрудника
     * @param name Имя сотрудника
     * @param age Возраст сотрудника
     * @param hourlyRate Почасовая ставка сотрудника
     */
    public Freelancer(String surname, String name, int age, double hourlyRate) {
        super(surname, name, age);
        this.hourlyRate = hourlyRate;
    }

    //endregion

    //region GETTERS AND SETTERS

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
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
        return WORK_DAYS_PER_MONTH * WORK_HOURS_PER_DAY * hourlyRate;
    }

    /**
     * Переопределение метода getSalary.
     *
     * @return Возвращает значение
     */
    @Override
    public double getSalary() {
        return calculateSalary();
    }

    /**
     * Вывод на экран информации о сотруднике Freelancer.
     *
     * @return Возвращает строку с данными по сотруднику
     */
    @Override
    public String toString() {
        return String.format("FREELANCER:\n%s (rate per hour: %.2f)", super.toString(), hourlyRate);
    }

    //endregion
}
