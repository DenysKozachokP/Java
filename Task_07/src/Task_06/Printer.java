package Task_06;

class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String data = sharedData.readData();
            if ("exit".equalsIgnoreCase(data)) {
                System.out.println("Printer: Завершення роботи.");
                break;
            }
            System.out.println("Printer отримав: " + data);
        }
    }
}