package ru.geekbrains.seminar5;

/*
1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет).
2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
4.* Написать метод, проверяющий, есть ли указанное слово в папке.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    private static final Random random = new Random();
    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;
    private static final String TO_SEARCH = "GeekBrains";

    public static void main(String[] args) throws IOException {
        writeFileContents("./testFiles/sample01.txt", 50);
        writeFileContents("./testFiles/sample02.txt", 65, 1);
        concatenate("./testFiles/sample01.txt",
                "./testFiles/sample02.txt",
                "./testFiles/sample_res.txt");

//        if (searchInFile("./testFiles/sample_res.txt", TO_SEARCH)) {
//            System.out.printf("Файл %s содержит искомое слово %s.\n",
//                    "./testFiles/sample_res.txt", TO_SEARCH);
//        }

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "./testFiles/file_" + i + ".txt";
            writeFileContents(fileNames[i], 30, 3);
            System.out.printf("Файл %s создан.\n", fileNames[i]);
        }

        List<String> result = searchMatch(new File("./testFiles"), TO_SEARCH);
        for (String s : result) {
            System.out.printf("Файл %s содержит искомое слово %s.\n", s, TO_SEARCH);
        }
    }

    /**
     * Метод записи последовательности символов в файл.
     *
     * @param fileName Имя файла
     * @param length   Количество символов для записи
     * @throws IOException Проброс исключений
     */
    private static void writeFileContents(String fileName, int length) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(generateSymbols(length).getBytes());
        }
    }

    /**
     * Метод записи последовательности символов в файл, а также с некоторой вероятностью искомого слова.
     *
     * @param fileName Имя файла
     * @param length   Количество символов для записи
     * @param i        Число для определения вероятности записи в файл искомого слова
     * @throws IOException Проброс исключений
     */
    private static void writeFileContents(String fileName, int length, int i) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            if (random.nextInt(i) == 0) {
                fileOutputStream.write(TO_SEARCH.getBytes());
            }

            fileOutputStream.write(generateSymbols(length).getBytes());
        }
    }

    /**
     * Метод "склеивания" двух файлов.
     *
     * @param fileIn1 Имя первого файла
     * @param fileIn2 Имя второго файла
     * @param fileOut Итоговый файл с содержимым из двух файлов
     * @throws IOException Проброс исключений
     */
    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException {
        // На запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {
            int c;

            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }

            // На чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn2)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }

    /**
     * Метод для определения, содержится ли в файле искомое слово.
     *
     * @param fileName Имя файла
     * @param search   Слово для поиска
     * @return Возвращает булевое значение, содержится ли искомое слово в файле
     * @throws IOException Проброс исключений
     */
    private static boolean searchInFile(String fileName, String search) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int c;
            int i = 0;

            while ((c = fileInputStream.read()) != -1) {
                if (c == searchData[i]) {
                    i++;
                } else {
                    i = 0;
                    if (c == searchData[i]) i++;
                    continue;
                }

                if (i == searchData.length) return true;
            }

            return false;
        }
    }

    /**
     * Метод поиска искомого слова в директории.
     *
     * @param dir    Имя директории
     * @param search Слово для поиска
     * @return Возвращает список с названием файлов, в которых сожержится искомое слово
     * @throws IOException Проброс исключений
     */
    private static List<String> searchMatch(File dir, String search) throws IOException {
        dir = new File(dir.getCanonicalPath());
        List<String> list = new ArrayList<>();
        File[] files = dir.listFiles();

        if (files == null) {
            return list;
        }

        for (File file : files) {
            if (file.isDirectory()) continue;
            if (searchInFile(file.getCanonicalPath(), search)) {
                list.add(file.getName());
            }
        }

        return list;
    }

    /**
     * Метод генерации некоторой последовательности символов.
     *
     * @param count Количество символов для генерации
     * @return Возвращает последовательность сгенерированных символов
     */
    private static String generateSymbols(int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }

        return sb.toString();
    }
}
