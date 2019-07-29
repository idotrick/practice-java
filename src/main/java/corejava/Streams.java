package corejava;

import java.util.Calendar;
import java.util.concurrent.*;

public class Streams {
    static volatile boolean isInterrupted = false;

    static ExecutorService es = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while(!isInterrupted) {
                System.out.println("working:"+ Calendar.getInstance().get(Calendar.SECOND));
                try {
                    Thread.currentThread().sleep(TimeUnit.SECONDS.toMillis(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t.interrupt();

        System.out.println("Main Continue"+ Calendar.getInstance().get(Calendar.SECOND));
        Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        System.out.println("Main Interrupt");
        isInterrupted = true;
    }
}
