package Task_04;

class ArithmeticProgression implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        while (result <= 100) {
            synchronized (ArithmeticProgression.class) {
                if (result > 100) {
                    break;
                }
                System.out.print(result + " ");
                result++;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": Потік перервано.");
                return;
            }
        }
    }
}

