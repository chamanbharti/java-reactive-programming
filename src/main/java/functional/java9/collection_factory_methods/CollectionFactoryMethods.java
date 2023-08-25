package functional.java9.collection_factory_methods;

import java.util.*;

public class CollectionFactoryMethods {

    public static void main(String[] args) {

        System.out.println("Old way to create collections");
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set = Collections.unmodifiableSet(set);
        //set.add("D");//UnsupportedOperationException
        System.out.println(set);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list = Collections.unmodifiableList(list);
        //list.add("D");//UnsupportedOperationException
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("A","Apple");
        map.put("B","Boy");
        map.put("C","Cat");
        map = Collections.unmodifiableMap(map);
        //map.put("D","Dog");//UnsupportedOperationException
        System.out.println(map);

        System.out.println("New way to create collections");
        Set<String> set1 = Set.of("A","B","C");
        //set1.add("D");//UnsupportedOperationException
        System.out.println(set1);

        List<String> list1 = List.of("A","B","C");
        //list1.add("D");//UnsupportedOperationException
        System.out.println(list1);

        Map<String, String> map1 = Map.of("A","Apple","B","Boy","C","Cat");
        //map1.put("D","Dog");//UnsupportedOperationException
        System.out.println(map1);

        Map<String,String>map2 = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("A","Apple"),
                new AbstractMap.SimpleEntry<>("B","Boy"),
                new AbstractMap.SimpleEntry<>("C","Cat")
        );
        System.out.println(map2);
    }
}
