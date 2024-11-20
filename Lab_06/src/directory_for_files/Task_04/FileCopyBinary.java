package directory_for_files.Task_04;
import java.io.*;

public class FileCopyBinary {
    public static void copyBinaryFile(String sourcePath, String destinationPath) {
        try (
                FileInputStream inputStream = new FileInputStream(sourcePath);
                FileOutputStream outputStream = new FileOutputStream(destinationPath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Бінарний файл успішно скопійовано.");
        } catch (IOException e) {
            System.err.println("Помилка копіювання бінарного файлу: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceBinaryFile = "src/directory_for_files/Task_04/image.jpg";
        String destinationBinaryFile = "src/directory_for_files/Task_04/copy_image.jpg";

        copyBinaryFile(sourceBinaryFile, destinationBinaryFile);
    }
}