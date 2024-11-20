package directory_for_files.Task_04;

import java.io.*;

public class FileCopyText {
    public static void copyTextFile(String sourcePath, String destinationPath) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Текстовий файл успішно скопійовано.");
        } catch (IOException e) {
            System.err.println("Помилка копіювання текстового файлу: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String strPath = "src/directory_for_files/Task_04/";
        String sourceTextFile = strPath + "source.txt";
        String destinationTextFile = strPath + "destination.txt";

        copyTextFile(sourceTextFile, destinationTextFile);
    }
}