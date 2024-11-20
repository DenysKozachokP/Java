package directory_for_files.Task_05;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileUTF8 {
    public static void main(String[] args) {
        String filePath = "src/directory_for_files/Task_05/products.txt";
        createInitialFile(filePath);
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(0);
            String header = "Нові товари:\n";
            raf.write(header.getBytes(StandardCharsets.UTF_8));
            long middlePosition = raf.length() / 2;
            raf.seek(middlePosition);
            String middleText = "\nДодатковий товар: Клавіатура - 800.00 ₴\n";
            raf.write(middleText.getBytes(StandardCharsets.UTF_8));
            raf.seek(raf.length());
            String footer = "Кінець списку товарів.\n";
            raf.write(footer.getBytes(StandardCharsets.UTF_8));

            System.out.println("Текст успішно дописано у файл.");
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        }
        readFileContent(filePath);
    }

    private static void createInitialFile(String filePath) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.setLength(0);
            String content = """
                    Товари:
                    1. Ноутбук - 25000.00 ₴
                    2. Мишка - 500.00 ₴
                    3. Монітор - 7000.00 ₴
                    """;
            raf.write(content.getBytes(StandardCharsets.UTF_8));
            System.out.println("Початковий файл створено.");
        } catch (IOException e) {
            System.err.println("Помилка створення початкового файлу: " + e.getMessage());
        }
    }

    private static void readFileContent(String filePath) {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            byte[] buffer = new byte[(int) raf.length()];
            raf.readFully(buffer);
            String content = new String(buffer, StandardCharsets.UTF_8);
            System.out.println("\nОновлений вміст файлу:");
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}