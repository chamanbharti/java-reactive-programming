package functional.java_16_features;

public record Demo() {
    /*
    public Demo() { // compact constructor
        System.out.println("default constructor");
    }
     */
    public Demo { // Canonical constructor
        System.out.println("default constructor");
    }
}
