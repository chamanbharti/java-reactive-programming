package functional.rx.sec02;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        /*
        Flux.fromIterable(strings).subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());
        // 7988502094 Ankit Mittal 9267954413,7303445792 gautam
        // 9267954413,7303445792 gautam
        // 9313023481
        // 8860225859
        Integer[] integers = {2,5,7,8};
        Flux.fromArray(integers).subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());
        */
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
        //stream.forEach(System.out::println);// closed
        //stream.forEach(System.out::println);//IE:stream has already been operated upon or closed
        Flux<Integer> integerFlux = Flux.fromStream(stream);
        integerFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        integerFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());// Error:java.lang.IllegalStateException: stream has already been operated upon or closed

    }
}
