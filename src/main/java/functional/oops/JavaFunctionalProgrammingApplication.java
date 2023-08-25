package functional.oops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JavaFunctionalProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFunctionalProgrammingApplication.class, args);
		System.out.println("hell");
		System.out.println(List.copyOf(Arrays.asList(1,2)));

		Optional<String> hubOfficeMail = Optional.ofNullable("");
		System.out.println(hubOfficeMail.orElse("no value"));;
		if(hubOfficeMail.isPresent()) {
			System.out.println(hubOfficeMail.get().substring(hubOfficeMail.get().indexOf("~")+1));
		}
	}

}
