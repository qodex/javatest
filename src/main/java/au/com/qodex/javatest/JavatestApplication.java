package au.com.qodex.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavatestApplication {

	public static void main(String[] args) {
		System.out.println("start the app.....");
		SpringApplication.run(JavatestApplication.class, args);
	}

}
