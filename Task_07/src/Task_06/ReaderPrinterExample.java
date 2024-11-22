package Task_06;

public class ReaderPrinterExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread readerThread = new Thread(new Reader(sharedData), "Reader");
        Thread printerThread = new Thread(new Printer(sharedData), "Printer");

        readerThread.start();
        printerThread.start();

        try {
            readerThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }

        System.out.println("Програма завершена.");
    }
}