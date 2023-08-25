package functional.java_16_features;

public record PersonRecord(String name, String address) {
    public PersonRecord{
        /*
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
         */
        if (name == null || address == null){
            throw new IllegalArgumentException("null input for(name or address) should not be passed");
        }
    }

    public static PersonRecord unnamed(String address) {
        return new PersonRecord("Unnamed", address);
    }

    public static String UNKNOWN_ADDRESS = "Unknown";

}
