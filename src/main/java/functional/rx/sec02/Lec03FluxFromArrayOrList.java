package functional.rx.sec02;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a","b","c");
        Flux.fromIterable(strings).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Integer[] integers = {2,5,7,8};
        Flux.fromArray(integers).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
