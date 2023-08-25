package functional.java_8_collectors.groupingBy;

// https://howtodoinjava.com/java/stream/collectors-groupingby/
//https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
/*
Syntax
groupingBy(classifier)
groupingBy(classifier, collector)
groupingBy(classifier, supplier, collector)

Syntax
groupingByConcurrent(classifier)
groupingByConcurrent(classifier, collector)
groupingByConcurrent(classifier, supplier, collector)
 */

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupingByExercise {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person(1, "Alex", 100d, new Department(1, "HR")),
                new Person(2, "Brian", 200d, new Department(1, "HR")),
                new Person(3, "Charles", 900d, new Department(2, "Finance")),
                new Person(4, "David", 200d, new Department(2, "Finance")),
                new Person(5, "Edward", 200d, new Department(2, "Finance")),
                new Person(6, "Frank", 800d, new Department(3, "ADMIN")),
                new Person(7, "George", 900d, new Department(3, "ADMIN"))
        );
        System.out.println("Grouping by Simple Condition");
        System.out.println("groupingBy(classifier)");
        System.out.println("Grouping all persons by department");
        Map<Department,List<Person>>groupingByDepartment = persons.stream()
                .collect(groupingBy(Person::getDepartment));
        System.out.println(groupingByDepartment);

        System.out.println("groupingBy(classifier, collector)");
        System.out.println("grouping all person ids by department");
        Map<Department,List<Integer>>groupingIdsByDepartment = persons.stream()
                .collect(
                 groupingBy(
                         Person::getDepartment,
                         Collectors.mapping(Person::getId,Collectors.toList())
                         )
                );
        System.out.println(groupingIdsByDepartment);


        System.out.println("Group by distinct department and salary pairs");
        Map<Object, List<Integer>> map = persons.stream()
                .collect(
                        groupingBy(
                                person -> new Pair(person.getSalary(), person.getDepartment()),
                                Collectors.mapping(Person::getId, Collectors.toList())
                                )
                       );

        System.out.println(map);

        System.out.println("Grouping with Counting");
        System.out.println("Count persons by department");
        Map<Department,Long>personCountByDepartment = persons.stream()
                .collect(
                        groupingBy(
                                      Person::getDepartment,
                                      Collectors.counting()
                                  )
                );
        System.out.println(personCountByDepartment);
        /* output:
        {
        Department[id=2, name=Finance]=3,
        Department[id=3, name=ADMIN]=2,
        Department[id=1, name=HR]=2
        }
         */
        System.out.println("Count persons with same salary");
        Map<Double,Long>countPersonWithSameSalary = persons.stream()
                .collect(
                        groupingBy(
                                Person::getSalary,
                                Collectors.counting()
                                )
                        );
        System.out.println(countPersonWithSameSalary);
        /* output:
        {
        800.0=1,
        200.0=3,
        100.0=1,
        900.0=2
        }
         */

        System.out.println("Average salary in each department");
        Map<Department,Double>averageSalaryEachDepartment = persons.stream()
                .collect(
                        groupingBy(
                                Person::getDepartment,
                                Collectors.averagingDouble(Person::getSalary)
                        )
                );
        System.out.println(averageSalaryEachDepartment);
        /* output:
        {
        Department[id=2, name=Finance]=433.3333333333333,
        Department[id=3, name=ADMIN]=850.0,
        Department[id=1, name=HR]=150.0
        }
         */

        System.out.println("Grouping with Max/Min");
        System.out.println(" finding the max salaried person in each department.");
        Map<Department, Optional<Person>> maxSalaried = persons.stream()
                .collect(
                        groupingBy(
                                Person::getDepartment,
                                minBy(Comparator.comparingDouble(Person::getSalary))
                        )
                );

        System.out.println(maxSalaried);
         /* output:
        {
       Department[id=2, name=Finance]=Optional[Person{id=3, name='Charles', salary=900.0, department=Department[id=2, name=Finance]}],
       Department[id=3, name=ADMIN]=Optional[Person{id=7, name='George', salary=900.0, department=Department[id=3, name=ADMIN]}],
       Department[id=1, name=HR]=Optional[Person{id=2, name='Brian', salary=200.0, department=Department[id=1, name=HR]}]
        }
         */

        System.out.println("Grouping with Filtering");
        System.out.println("Filtering all persons with salary less than 300");
        Map<Department, Long> lessThanSalary = persons.stream()
                .filter(p -> p.getSalary() > 300)
                .collect(
                        groupingBy(
                                Person::getDepartment,
                                counting()
                        )
                );

        System.out.println(lessThanSalary);

        System.out.println("groupingBy(classifier, supplier, collector)");
        System.out.println("Filtering all persons with salary less than 300");
        Map<Department, Long> lessThanSalary2 = persons.stream()
                .collect(
                        groupingBy(
                                Person::getDepartment,
                                filtering(p -> p.getSalary() > 300d,
                                counting())
                        )
                );

        System.out.println(lessThanSalary2);
    }
}
