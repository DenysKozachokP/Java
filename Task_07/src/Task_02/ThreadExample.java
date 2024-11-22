package Task_02;

public class ThreadExample {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        System.out.println("Стан потоку: " + myThread.getState());

        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи живий: " + myThread.isAlive());
        System.out.println("Чи є демоном: " + myThread.isDaemon());

        myThread.setName("ProgrammingThread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        myThread.start();

        new Thread(() -> {
            while (myThread.isAlive()) {
                System.out.println("Стан потоку: " + myThread.getState());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Стан потоку: " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
}