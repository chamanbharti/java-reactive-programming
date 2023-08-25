package functional.rx.sec05;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxCreateIssueFix {

    public static void main(String[] args) {
        // map
        // filter
        Flux.range(1,10)
                .takeLast(3)//cancels
                .log()
                .subscribe(Util.subscriber());
    }
}
