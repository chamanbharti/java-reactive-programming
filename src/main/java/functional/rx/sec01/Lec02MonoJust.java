package functional.rx.sec01;

import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class Lec02MonoJust {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        mono.subscribe(System.out::println);
        mono.subscribe(i -> System.out.println("Received: "+i));
    }
}
