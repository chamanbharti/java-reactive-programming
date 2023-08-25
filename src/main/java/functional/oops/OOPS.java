package functional.oops;

import java.util.*;
import java.util.stream.IntStream;



public class OOPS {
    public static void main(String[] args) {
/*
- Object
- Class
- Abstraction
- Encapsulation
- Inheritance
- Polymorphism
- Composition
- Aggregation
- Association
- Cohesion
- Coupling
- Delegation
*/

        List<Integer> list = List.of(1,2,3,4,5,6,6,6,7,7,7,8,8);
        int item = 5;
        System.out.println(getIndex(list,item));
        int result = IntStream.range(0,list.size())
                .filter(i-> Objects.equals(list.get(i),item))
                .findFirst()
                .orElse(-1);
        System.out.println(result);

        Map<Employee, Integer> map = new HashMap<>();

        Employee e1 = new Employee(1,"abc");
        Employee e2 = new Employee(1,"abc");
        Employee e3 = new Employee(1,"abc");
        Employee e4 = new Employee(2,"abc");

        System.out.println(map.put(e1,1));
        System.out.println(map.put(e2,2));
        System.out.println(map.put(e3,3));
        map.put(e4,2);
        System.out.println(map.size());
        System.out.println(map.get(e4));

        //Find a pair with the given sum in an array
        int[] nums = { 8, 7, 2, 5, 3, 1 };
        int target = 10;
        pair(nums,target);
    }

    private static void pair(int[] nums, int target) {
        /*
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j< nums.length;j++){
                if (nums[i]+nums[j]==target){
                    System.out.printf("pair found(%d %d) ",nums[i],nums[j]);
                    return;
                }
            }
        }*/
        /*
        Map<Integer,Integer>map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                System.out.printf("pair found(%d %d) ",nums[map.get(target - nums[i])],nums[i]);
                return;
            }
            map.put(nums[i],i);
        }
         */
        Arrays.sort(nums);
        int low=0;
        int high = nums.length-1;
        while (low<high){
            if(nums[low]+nums[high]==target){
                System.out.printf("pair found(%d %d) ",nums[low],nums[high]);
                return;
            }
            if(nums[low]+nums[high]<target){
                low++;
            }else {
                high--;
            }
        }
        System.out.println("Pair not found");
    }

    public static String getIndex(List<Integer>list,int target){
        return "{"+list.indexOf(target)+","+list.lastIndexOf(target)+"}";
    }
}
