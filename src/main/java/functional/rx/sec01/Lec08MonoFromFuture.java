package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec08MonoFromFuture {

    public static void main(String[] args) {

        Mono.fromFuture(getName()).subscribe(Util.onNext());
        Util.sleep(1);

    }
    private static CompletableFuture<String> getName(){
        System.out.println("Generating name..");
        return CompletableFuture.supplyAsync( ()-> Util.faker().name().fullName());
    }
}
