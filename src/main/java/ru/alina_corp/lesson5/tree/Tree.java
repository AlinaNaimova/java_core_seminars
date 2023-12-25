package ru.alina_corp.lesson5.tree;

import java.io.File;

public class Tree {

    public static void main(String[] args) {
        File rootDir = new File("."); // Замените "путь_к_корневой_директории" на нужный путь
        if (rootDir.exists()) {
            print(rootDir, "", true); // Вызываем метод print, начиная с корневой директории
        } else {
            System.out.println("Корневая директория не найдена.");
        }
    }

    /**
     * Рекурсивно отображает дерево директорий и файлов.
     * @param file Файл или директория, для которых нужно отобразить содержимое
     * @param indent Отступ для текущего уровня вложенности
     * @param isLast Флаг, указывающий, является ли текущий элемент последним в списке
     */
    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;

            int subDirTotal = 0;
            for (File f : files) {
                if (f.isDirectory()) {
                    subDirTotal++;
                }
            }

            int subDirCounter = 0;
            for (File f : files) {
                print(f, indent, subDirTotal == ++subDirCounter);
            }
        }
    }
}