package _24oct;

public class PrintABC1 {
    static final Object lock = new Object();
    static volatile char letter = 'A';

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (letter != 'A') {
                        try {
                            lock.wait();
                        } catch (Exception ignored) {

                        }
                    }
                    System.out.println(letter);
                    letter = 'B';
                    lock.notifyAll();
                }
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (letter != 'C') {
                        try {
                            lock.wait();
                        } catch (Exception ignored) {

                        }
                    }
                    System.out.println(letter);
                    letter = 'A';
                    lock.notifyAll();
                }
            }

        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (letter != 'B') {
                        try {
                            lock.wait();
                        } catch (Exception ignored) {

                        }
                    }
                    System.out.println(letter);
                    letter = 'C';
                    lock.notifyAll();
                }
            }

        }).start();
    }


}
