package directory_for_files.Task_06;

import java.io.File;
import java.io.IOException;

public class Task_06 {
    public static void main(String[] args) {
        try {
            File innerDirectory = new File("src/directory_for_files/Task_06/inner_directory");
            if (innerDirectory.mkdir()) {
                System.out.println("Папка створена: " + innerDirectory.getAbsolutePath());
            } else {
                System.out.println("Папка вже існує або не вдалося створити.");
            }
            System.out.println("Абсолютний шлях: " + innerDirectory.getAbsolutePath());

            System.out.println("Батьківська директорія: " + innerDirectory.getParent());

            File file1 = new File(innerDirectory, "file1.txt");
            File file2 = new File(innerDirectory, "file2.txt");
            if (file1.createNewFile()) {
                System.out.println("Файл створено: " + file1.getName());
            }
            if (file2.createNewFile()) {
                System.out.println("Файл створено: " + file2.getName());
            }
            if (file1.delete()) {
                System.out.println("Файл видалено: " + file1.getName());
            }

            File renamedDirectory = new File("src/directory_for_files/Task_06/renamed_inner_directory");
            if (innerDirectory.renameTo(renamedDirectory)) {
                System.out.println("Папка перейменована в: " + renamedDirectory.getName());
            }
            File directoryForFiles = new File("directory_for_files");
            if (directoryForFiles.exists() || directoryForFiles.mkdir()) {
                File exampleFile1 = new File(directoryForFiles, "example1.txt");
                File exampleFile2 = new File(directoryForFiles, "example2.txt");
                exampleFile1.createNewFile();
                exampleFile2.createNewFile();
            }

            System.out.println("Вміст папки directory_for_files:");
            File[] filesAndDirs = directoryForFiles.listFiles();
            if (filesAndDirs != null) {
                for (File file : filesAndDirs) {
                    String type = file.isDirectory() ? "Папка" : "Файл";
                    System.out.printf("%-15s %-8s Розмір: %d байт%n", file.getName(), type, file.length());
                }
            } else {
                System.out.println("Папка directory_for_files порожня.");
            }
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}