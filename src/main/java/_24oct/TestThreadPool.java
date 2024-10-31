package _24oct;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i=0;i<21;i++){
            int finalI = i;
            threadPoolExecutor.execute(()->{
                System.out.println("count: "+ finalI);
                try {
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        System.out.println("main thread ");


    }
}
