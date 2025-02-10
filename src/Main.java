import java.util.Random;

class RandomNumberThread extends Thread {
    private boolean even;

    public RandomNumberThread(boolean even) {
        this.even = even;
    }

    @Override
    public void run() {
        Random random = new Random();
        if (even) {
            System.out.println("Випадкові парні числа:");
            for (int i = 0; i < 10; i++) {
                int num = 2 * random.nextInt(50);
                System.out.println(num);
            }
        } else {
            System.out.println("Випадкові числа:");
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(100);
                System.out.println(num);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RandomNumberThread thread1 = new RandomNumberThread(false);
        RandomNumberThread thread2 = new RandomNumberThread(true);

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Потік перервано: " + e.getMessage());
        }

        System.out.println("Обидва потоки завершили свою роботу.");
    }
}
