package com.company;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileTest {
    static Logger LOGGER;
    static {
        try (FileInputStream inputStream = new FileInputStream("D://111//log.config")){
            LogManager.getLogManager().readConfiguration(inputStream);
            LOGGER = Logger.getLogger(FileTest.class.getName());
        }catch (IOException e){

        }
    }
    public static void createFile(){
        String fileName = "text.txt";
        String folderName = System.getProperty("user.dir");
        String fullName = folderName + File.separator + fileName;
        File file = new File(fullName);

        if (!file.exists()){
            try{
                if (file.createNewFile()){
                    LOGGER.log(Level.INFO, "Создан тестовый файл.");
                }
                else {
                    LOGGER.log(Level.INFO, "Тестовый файл не создан.");
                }
            }catch (IOException e){
                LOGGER.log(Level.SEVERE, "Ошибка системы ввода/вывода.", e);
            }
        }
        else {
            LOGGER.log(Level.INFO, "Файл существует.");
        }
    }

    public static void getFileList(String path){
        File folder = new File(path);
        for (File item : folder.listFiles()){
            if (item.isDirectory()){
                System.out.println(item.getAbsolutePath());
                System.out.println(Arrays.toString(folder.listFiles(File::isDirectory)));
                System.out.println(Arrays.toString(folder.listFiles(File::isFile)));
                getFileList(item.getAbsolutePath());
            }
        }
        /*if (folder.isDirectory()){
            System.out.println(Arrays.toString(folder.listFiles(File::isFile)));
            System.out.println(Arrays.toString(folder.listFiles(File::isDirectory)));
        }*/
    }

    public static void main(String[] args) {
        createFile();
        getFileList("D://");
    }
}
