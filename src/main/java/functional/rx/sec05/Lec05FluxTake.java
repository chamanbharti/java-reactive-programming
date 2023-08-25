package functional.rx.sec05;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxTake {

    public static void main(String[] args) {
        // map
        // filter
        Flux.range(1,10)
                .take(3)//cancels
                .log()
                .subscribe(Util.subscriber());
    }
}
