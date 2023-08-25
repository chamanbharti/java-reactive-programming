package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec07SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println("name:"+name);
        getName();
        Util.sleep(4);


    }
    private static Mono<String> getName(){
        System.out.println("entered getName method");
        return Mono.fromSupplier( ()->{
            System.out.println("Generating name..");
            Util.sleep(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
