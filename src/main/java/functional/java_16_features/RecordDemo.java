package functional.java_16_features;

public class RecordDemo {

    public static void main(String[] args) {

        System.out.println("**Constructor**");
        Person person = new Person("John Doe", "100 Linda Ln.");
        PersonRecord personRecord = new PersonRecord("John Doe", "100 Linda Ln.");

        System.out.println("**Getter**");
        System.out.println(person.getName());
        System.out.println(person.getAddress());

        System.out.println(personRecord.name());
        System.out.println(personRecord.address());

        System.out.println("**equals**");
        Person person2 = person;
        PersonRecord personRecord2 = personRecord;
        System.out.println(person.getName().equals(person2.getName()));
        System.out.println(personRecord.name().equals(personRecord2.name()));

        System.out.println("**hashcode**");
        System.out.println(person.hashCode()==person2.hashCode());
        System.out.println(personRecord.hashCode() == personRecord2.hashCode());

        System.out.println("**toString**");
        System.out.println(person);
        System.out.println(personRecord);

        System.out.println("**Constructor**");
        PersonRecord personRecord3 = new PersonRecord("null","null");
        System.out.println(personRecord3);

//        PersonRecord ownConstructor = new PersonRecord("Chaman");
//        System.out.println(ownConstructor);

        System.out.println("Static Variables & Methods");
        System.out.println(PersonRecord.UNKNOWN_ADDRESS);
        System.out.println(PersonRecord.unnamed("Noida"));

        record Foo(int[] ints){}
        var ints = new int[]{1, 2};
        var foo = new Foo(ints);
        System.out.println(foo); // Foo[ints=[I@6433a2]
        System.out.println(new Foo(new int[]{1,2}).equals(new Foo(new int[]{1,2}))); // false
        System.out.println(new Foo(ints).equals(new Foo(ints))); //true
        System.out.println(foo.equals(foo)); // true

        // comparable
//        Student student1 = new Student(10,"null");
//        System.out.println(student1);
//        Student student2 = new Student(5);
//        System.out.println(student1.compareTo(student2));

        Student student1 = new Student(10,"Chaman");
        Student student2 = new Student(20,"Chaman");
        System.out.println(student1.compare(student1,student2));

        Demo demo = new Demo();
        System.out.println(demo);

    }
}
