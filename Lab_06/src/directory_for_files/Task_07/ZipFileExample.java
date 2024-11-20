package directory_for_files.Task_07;
import java.io.*;
import java.util.zip.*;

public class ZipFileExample {
    public static void main(String[] args) {
        String directoryPath = "src/directory_for_files/Task_07/PackExam";
        String zipFilePath = "src/directory_for_files/Task_07/files_archive.zip";
        try {
            createZip(directoryPath, zipFilePath);
        } catch (IOException e) {
            System.err.println("Помилка при створенні архіву: " + e.getMessage());
        }

        try {
            listFilesInZip(zipFilePath);
        } catch (IOException e) {
            System.err.println("Помилка при читанні архіву: " + e.getMessage());
        }
    }
    private static void createZip(String directoryPath, String zipFilePath) throws IOException {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new FileNotFoundException("Директорія не знайдена: " + directoryPath);
        }

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        addFileToZip(file, zos);
                    }
                }
                System.out.println("Файли успішно додано до архіву: " + zipFilePath);
            } else {
                System.out.println("Папка порожня або не знайдена.");
            }
        }
    }
    private static void addFileToZip(File file, ZipOutputStream zos) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }
        System.out.println("Файл додано до архіву: " + file.getName());
    }
    private static void listFilesInZip(String zipFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            System.out.println("\nСписок файлів в архіві:");
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                System.out.println("- " + zipEntry.getName());
                zis.closeEntry();
            }
        }
    }
}
