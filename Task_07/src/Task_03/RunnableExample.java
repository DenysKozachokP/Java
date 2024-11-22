package Task_03;

public class RunnableExample {
    public static void main(String[] args) {

        Runnable task = new MyRunnable();

        Thread thread1 = new Thread(task, "Потік-1");
        Thread thread2 = new Thread(task, "Потік-2");
        Thread thread3 = new Thread(task, "Потік-3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Головний потік перервано.");
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}