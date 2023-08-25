package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;

public class Lec09MonoFromRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("");
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done. Sending emails...");
                        }
                );

    }
    private static Runnable timeConsumingProcess(){
        return () -> {
            Util.sleep(3);
            System.out.println("Operation completed");
        };
    }
}
