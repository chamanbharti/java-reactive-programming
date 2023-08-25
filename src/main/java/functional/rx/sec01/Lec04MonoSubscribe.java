package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoSubscribe {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);
        // 1
        //mono.subscribe();
        // 2
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

}
