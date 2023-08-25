package functional.java9.process;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessBuilderDemo {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        String np = "Not Present";
        Process p = pb.start();
        ProcessHandle.Info info = p.info();
        System.out.printf("Process ID : %s%n", p.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

        System.out.printf("Start time: %s%n",info.arguments()
                .map(a-> Stream.of(a).collect(
                        Collectors.joining(" ")
                )).orElse(np)
        );
        System.out.printf("User : %s%n", info.user().orElse(np));
    }
}
