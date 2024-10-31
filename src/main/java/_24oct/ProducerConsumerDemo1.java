package _24oct;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerDemo1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                    blockingQueue.put(i);
                    System.out.println("produce "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("consume "+blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

}
