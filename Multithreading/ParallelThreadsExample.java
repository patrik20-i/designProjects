package Multithreading;

public class ParallelThreadsExample {
    public static void main(String[] args) {
        Thread numbersThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(100); // sleep to slow things down so we can see interleaving
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread lettersThread = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println("Letter: " + c);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        numbersThread.start();
        lettersThread.start();
    }
}
