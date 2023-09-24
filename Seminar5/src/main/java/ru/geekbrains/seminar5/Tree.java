package ru.geekbrains.seminar5;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    /**
     * Рекурсивный метод печати директорий и файлов в виде дерева.
     * Перед директориями в скобках стоит указатель (d), перед файлами - (f).
     *
     * @param file   Имя рутовой директории
     * @param indent Отступ
     * @param isLast Булевое значение, является ли директория последней
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);

        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }

        if (file.isDirectory()) {
            System.out.println("(d)  " + file.getName());
        } else {
            System.out.println("(f)  " + file.getName());
            return;
        }

        File[] files = file.listFiles();
        if (files == null) return;

        int subDirTotal = 0;
        int subFTotal = 0;

        for (File fileName : files) {
            if (fileName.isDirectory()) {
                subDirTotal++;
            } else {
                subFTotal++;
            }
        }

        int subDirCounter = 0;
        int subFCounter = 0;

        for (File fileName : files) {
            if (fileName.isDirectory()) {
                subDirCounter++;
                print(fileName, indent, subDirCounter == subDirTotal && subFCounter == subFTotal);
            } else {
                subFCounter++;
                print(fileName, indent, subFCounter == subFTotal && subDirCounter == subDirTotal);
            }
        }
    }
}
