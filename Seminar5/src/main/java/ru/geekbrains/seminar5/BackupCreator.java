package ru.geekbrains.seminar5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupCreator {
    public static void main(String[] args) {
        String dirName = "./testFiles";
        createBackup(dirName);
    }

    /**
     * Метод копирования файлов из указанной директории в новую ./backup
     *
     * @param dirName Имя директории, из которой необходимо копировать файлы
     */
    private static void createBackup(String dirName) {
        File dir = new File(dirName);

        if (dir.exists() && dir.isDirectory()) {
            File backupDirName = new File("./backup");

            if (!backupDirName.exists() || !backupDirName.isDirectory()) {
                backupDirName.mkdir();
            }

            File[] files = dir.listFiles();

            if (files == null) {
                System.out.printf("В указанной директории %s нет файлов для копирования.\n", dirName);
                return;
            }

            try {
                for (File file : files) {
                    File copyFile = new File(backupDirName + "/" + file.getName());
                    if (file.isFile()) {
                        Files.copy(file.toPath(), copyFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }

                System.out.printf("Резервное копирование файлов из директории %s успешно завершено.\n", dirName);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.printf("Директория %s не найдена!\n", dirName);
        }
    }
}
