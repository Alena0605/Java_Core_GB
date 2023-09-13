package ru.geekbrains.seminar2;

import java.util.Random;
import java.util.Scanner;

public class Program {
    private static final char DOT_HUMAN = 'X';   // Отметка игрока
    private static final char DOT_AI = '0';      // Отметка компьютера
    private static final char DOT_EMPTY = '*';   // Пустая ячейка

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;   // Текущее состояние поля

    private static int fieldSize;   // Размер поля
    private static int winCount;    // Количество подряд стоящих отметок для победы

    public static void main(String[] args) {
        initialize();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkGameState(DOT_HUMAN, "Вы победили!")) {
                break;
            }

            aiTurn();
            printField();
            if (checkGameState(DOT_AI, "Компьютер победил! :(")) {
                break;
            }
        }
    }

    /**
     * Инициализация условий игры.
     * Минимальный размер поля 3х3. В этом случае условием для победы будет 3 стоящие подряд отметки.
     * Если размер поля больше, то игрок сам задаёт количество отметок для победы.
     */
    private static void initialize() {
        while (true) {
            System.out.print("Укажите размерность поля (введите ОДНУ цифру) >>> ");
            if (scanner.hasNextInt()) {
                fieldSize = scanner.nextInt();
                scanner.nextLine();
                if (fieldSize < 3) {
                    System.out.println("Размер поля не может быть меньше, чем 3х3, повторите попытку.");
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод, повторите попытку.");
                scanner.nextLine();
            }
        }

        if (fieldSize == 3) {
            winCount = 3;
        } else {
            while (true) {
                System.out.print("Укажите количество отметок для победы (минимум 3) >>> ");
                if (scanner.hasNextInt()) {
                    winCount = scanner.nextInt();
                    scanner.nextLine();
                    if (winCount < 3) {
                        System.out.println("Значение не может быть меньше 3-х, повторите попытку.");
                    } else if (winCount > fieldSize) {
                        System.out.println("Количество отметок для победы не может быть больше размера поля, " +
                                "повторите попытку.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Некорректный ввод, повторите попытку.");
                    scanner.nextLine();
                }
            }
        }

        field = new char[fieldSize][fieldSize];

        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Вывод игрового поля:
     *     1 2 3
     *   1|*|X|0|
     *   2|*|*|*|
     *   3|*|*|0|
     *   --------
     */
    private static void printField() {
        System.out.print(" ");
        for (int x = 0; x < fieldSize * 2 + 1; x++) {
            System.out.print((x % 2 == 0) ? " " : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSize; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSize; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSize * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * Обработка хода игрока (человека).
     */
    private static void humanTurn() {
        int x, y;

        do {
            while (true) {
                System.out.print("Введите номер строки >>> ");
                if (scanner.hasNextInt()) {
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректный ввод, повторите попытку.");
                    scanner.nextLine();
                }
            }

            while (true) {
                System.out.print("Введите номер столбца >>> ");
                if (scanner.hasNextInt()) {
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Некорректный ввод, повторите попытку.");
                    scanner.nextLine();
                }
            }
        }
        while(!isCellValid(x, y) || !isCellEmpty(x, y));

        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, что ячейка пустая.
     *
     * @param x столбец поля
     * @param y строка поля
     * @return возвращает результат проверки
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода координат ячейки.
     *
     * @param x столбец поля
     * @param y строка поля
     * @return возвращает результат проверки
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    /**
     * Обработка хода компьютера.
     */
    private static void aiTurn() {
        int x, y;

        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        }
        while(!isCellEmpty(x, y));

        field[x][y] = DOT_AI;
    }

    /**
     * Проверка текущего состояния игры.
     *
     * @param c символ игрока
     * @param s строка, извещающая о победе игрока или AI
     * @return возвращает результат проверки
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    /**
     * Проверка победы.
     *
     * @param c символ игроков (X или 0)
     * @return возвращает результат проверки
     */
    private static boolean checkWin(char c) {
        // Проверка по горизонтали
        for (int x = 0; x < fieldSize; x++) {
            int checkWin = 0;
            for (int y = 0; y < fieldSize; y++) {
                if (field[x][y] == c) {
                    checkWin++;
                } else if (field[x][y] != c || checkWin == winCount) {
                    break;
                }
            }

            if (checkWin == winCount) return true;
        }

        // Проверка по вертикали
        for (int y = 0; y < fieldSize; y++) {
            int checkWin = 0;
            for (int x = 0; x < fieldSize; x++) {
                if (field[x][y] == c) {
                    checkWin++;
                } else if (field[x][y] != c || checkWin == winCount) {
                    break;
                }
            }

            if (checkWin == winCount) return true;
        }

        int maxOffset = fieldSize - winCount;

        // Проверка по диагонали (вниз и вправо)
        for (int row = 0; row <= maxOffset; row++) {
            int offset = 0;
            int checkWin = 0;

            while (offset <= maxOffset) {
                for (int x = 0; x < fieldSize - offset; x++) {
                    if (field[x + row][x + offset] == c) {
                        checkWin++;
                    } else if (field[x][x + offset] != c || checkWin == winCount) {
                        break;
                    }
                }

                offset++;
            }

            if (checkWin == winCount) return true;
        }

        // Проверка по диагонали (вниз и влево)
        for (int row = 0; row <= maxOffset; row++) {
            int offset = 0;
            int checkWin = 0;

            while (offset <= maxOffset) {
                for (int x = 0; x < fieldSize - offset; x++) {
                    if (field[x + row][fieldSize - 1 - x - offset] == c) {
                        checkWin++;
                    } else if (field[x + row][fieldSize - 1 - x - offset] != c || checkWin == winCount) {
                        break;
                    }
                }

                offset++;
            }

            if (checkWin == winCount) return true;
        }

        return false;
    }

    /**
     * Проверка на ничью.
     *
     * @return возвращает результат проверки
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }
}
