package functional.rx.sec01;

import functional.rx.util.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(21)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){
        if (userId == 1){
            return Mono.just(Util.faker().name().firstName());
        }else if(userId == 2){
            return Mono.empty();//null
        }else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
