package functional.rx.sec02;

import functional.rx.sec02.helper.NameGenerator;
import functional.rx.util.Util;

public class Lec07FluxVsList {
    public static void main(String[] args) {
       // List<String>names = NameGenerator.getNames(5);
       // System.out.println(names);
        NameGenerator.getNames(5).subscribe(Util.onNext());
    }
}
