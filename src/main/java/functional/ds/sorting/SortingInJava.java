package functional.ds.sorting;

import java.util.Arrays;
import java.util.Collections;
//https://mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
//https://mkyong.com/java8/java-8-how-to-sort-a-map/
public class SortingInJava {

    public static void main(String args[]) {

        String[] unsortStringArray = new String[]{"c", "b", "a", "3", "2", "1"};
        int[] unsortIntArray = new int[]{7, 5, 4, 6, 1, 2, 3};

        System.out.println("Before sort");
        System.out.println("--- unsortStringArray ---");
        for (String temp : unsortStringArray) {
            System.out.println(temp);
        }
        System.out.println("--- unsortIntArray ---");
        for (int temp : unsortIntArray) {
            System.out.println(temp);
        }

        //sort it
        Arrays.sort(unsortStringArray);
        Arrays.sort(unsortIntArray);

        System.out.println("After sorted");
        System.out.println("--- unsortStringArray ---");
        for (String temp : unsortStringArray) {
            System.out.println(temp);
        }
        System.out.println("--- unsortIntArray ---");
        for (int temp : unsortIntArray) {
            System.out.println(temp);
        }

        //sort it, reverse order
        Arrays.sort(unsortStringArray, Collections.reverseOrder());

        System.out.println("After sorted - reserved order");
        System.out.println("--- unsortStringArray ---");
        for (String temp : unsortStringArray) {
            System.out.println(temp);
        }
      }

    }
