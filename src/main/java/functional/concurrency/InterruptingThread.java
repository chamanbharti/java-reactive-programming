package functional.concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptingThread {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
//        try {
//            TimeUnit.SECONDS.sleep(5000);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//        task.interrupt();
    }
}
