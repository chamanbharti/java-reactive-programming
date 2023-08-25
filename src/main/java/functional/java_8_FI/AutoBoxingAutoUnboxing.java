package functional.java_8_FI;

import java.util.function.*;

public class AutoBoxingAutoUnboxing {
    //auto boxing = primitive type to object type
    //auto unboxing = object type to primitive type
    public static void main(String[] args) {

        int[] array ={0,5,10,15,20,25};
        long startTime = System.currentTimeMillis();
        Predicate<Integer> p = i->i%2==0;
        for (int x:array){
            if(p.test(x)){
                System.out.println(x);
            }
        }
        System.out.println("time taken:"+(System.currentTimeMillis()-startTime));
        /*
In the above examples,6 times autoboxing and autounboxing happening which creates Performance problems.
To overcome this problem primitive functional interfaces introduced,
which can always takes primitive types as input and return primitive types.
Hence autoboxing and autounboxing won't be required,which improves performance.
         */
        startTime = System.currentTimeMillis();
        IntPredicate p2 = i->i%2==0;
        for (int x:array){
            if(p2.test(x)){
                System.out.println(x);
            }
        }
        System.out.println("time taken:"+(System.currentTimeMillis()-startTime));
        /*
        In the above example, autoboxing and autounboxing won't be performed internally.
        Hence performance wise improvements are there.
         */
        IntPredicate pi = i->i%2==0;
        System.out.println(pi.test(4));
        LongPredicate pl = i->i%2==0;
        System.out.println(pl.test(4));
        DoublePredicate pd = i->i%2==0;
        System.out.println(pd.test(4));

        System.out.println("Primitive Type Functional Interfaces for Function:");
        //IntFunction: can take int type as input and return any type
        IntFunction<Boolean> fi = i->i%2==0;
        System.out.println(fi.apply(4));
        LongFunction<Boolean> fl = i->i%2==0;
        System.out.println(fl.apply(4));
        DoubleFunction<Boolean> fd = i->i%2==0;
        System.out.println(fd.apply(4));

        //ToIntFunction: It can take any type as input but always returns int type
        ToIntFunction<String> fit = i->i.length();
        System.out.println(fit.applyAsInt("chaman"));
        ToLongFunction<String> flt = i->i.length();
        System.out.println(flt.applyAsLong("chaman"));
        ToDoubleFunction<String> fdt = i->i.length();
        System.out.println(fdt.applyAsDouble("chaman"));

        //IntToLongFunction: It can take int type as input and returns long type
        IntToLongFunction itlf = i->i/2;
        System.out.println(itlf.applyAsLong(4));
        IntToDoubleFunction x = i->i/2;
        System.out.println(x.applyAsDouble(4));
        LongToDoubleFunction y = i->i/2;
        System.out.println(y.applyAsDouble(4));




    }
}
