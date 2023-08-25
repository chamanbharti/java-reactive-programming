package functional.java9.try_with_resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TryWithResource {
    public static void main(String[] args) {
        try {
            System.out.println(readData("test"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String readData(String message) throws IOException {
        // before java 9
        Reader inputString = new StringReader(message);
        BufferedReader br = new BufferedReader(inputString);
        /*
        try(BufferedReader br1 = br){
            return br1.readLine();
        }
        */

        // after java 9
        try(br){
            return br.readLine();
        }

    }
}
