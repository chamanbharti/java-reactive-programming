package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec06MonoFromSupplier {

    public static void main(String[] args) {
        // use just only when you have data already
        // Mono<String> mono = Mono.just(getName());
//        Mono<String> mono = Mono.fromSupplier( ()-> getName());
        Supplier<String>supplier = ()-> getName();
        Mono<String> mono = Mono.fromSupplier(supplier);

        mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Callable<String> callable = () -> getName();
        Mono<String> mono1 = Mono.fromCallable(callable);
        mono1.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
    private static String getName(){
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
