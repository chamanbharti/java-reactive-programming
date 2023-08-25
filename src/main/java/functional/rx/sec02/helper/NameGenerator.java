package functional.rx.sec02.helper;

import functional.rx.util.Util;
import reactor.core.publisher.Flux;

public class NameGenerator {
    // using List
    /*
    public static List<String> getNames(int count){
        List<String>list = new ArrayList<>(count);
        for(int i=0;i<count;i++){
            list.add(getName());
        }
        return list;
    }
    */

    // using flux
    public static Flux<String> getNames(int count){
        return Flux.range(0,count).map(i->getName());
    }
    private static String getName(){
        System.out.println("Generating name");
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
