package idv.nick.jcconf2024;

import org.springframework.boot.SpringApplication;

public class TestJcconf2024Application {

	public static void main(String[] args) {
		SpringApplication.from(Jcconf2024Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
