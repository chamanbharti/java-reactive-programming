package functional.rx.sec05;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

public class Test {
    public static void main(String[] args) {
        System.out.println("cold");

        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
        });
        Flux<Integer> map = flux.map(i -> i * 2);
        map.subscribe(System.out::println);
        map.subscribe(System.out::println);

        System.out.println("hot ");

        Flux<Object> flux2 = Flux.create(fluxSink -> {
                    System.out.println("created");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .publish()
                .refCount(2);
        flux2.subscribe(System.out::println);
        flux2.subscribe(System.out::println);
        flux2.subscribe(System.out::println);

        System.out.println("*********");
        Flux<Integer> flux3 = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });
        Flux<Integer> cache = flux3.filter(i -> i > 1).cache(1);

        cache.subscribe(Util.subscriber());
        cache.subscribe(Util.subscriber());

   }
}
