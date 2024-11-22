package Task_06;

class SharedData {
    private String data = null;
    private boolean dataAvailable = false;

    public synchronized void writeData(String input) {
        while (dataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader потік перервано.");
            }
        }
        data = input;
        dataAvailable = true;
        notify();
    }

    public synchronized String readData() {
        while (!dataAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Printer потік перервано.");
            }
        }
        String output = data;
        data = null;
        dataAvailable = false;
        notify();
        return output;
    }
}