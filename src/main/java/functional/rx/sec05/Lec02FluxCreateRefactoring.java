package functional.rx.sec05;

import functional.rx.sec05.helper.NameProducer;
import functional.rx.util.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {
        /*
        Flux.create(fluxSink -> {

//          fluxSink.next(1);
//          fluxSink.next(2);
//          fluxSink.complete();


//           for (int i=0;i<10;i++){
//               fluxSink.next(Util.faker().country().name());
//           }
//           fluxSink.complete();


            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.toLowerCase().equals("canada"));
            fluxSink.complete();

        }).subscribe(Util.onNext());
        */

        /*
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());
        nameProducer.produce();
        */
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());
        Runnable runnable = nameProducer::produce;
        for (int i=0;i<10;i++){
            new Thread(runnable).start();
        }
        Util.sleepSeconds(2);
    }
}
