package com.company;

import java.io.File;
import java.io.IOException;

public class FolderTest {

    public static void main(String[] args) {
        File folder = new File("D://111//222");
        boolean created = folder.mkdir(); //создать каталог (папку)

        if (created){
            System.out.println("Папка создана. Путь: " + folder.getAbsolutePath());
        }
        else {
            System.out.println("Папка не создана");
        }

        File newFolder = new File("D://111//new222");
        boolean rename = folder.renameTo(newFolder);

        if (rename){
            System.out.println("Папка " + folder.getAbsolutePath() + " переименована в " + newFolder.getAbsolutePath());
        }
        else {
            System.out.println("Переименовать не удалось.");
        }

        boolean delete = newFolder.delete();

        if (delete){
            System.out.println("Папка " + newFolder.getAbsolutePath() + " удалена.");
        }
        else {
            System.out.println("Удалить не удалось.");
        }
    }
}
