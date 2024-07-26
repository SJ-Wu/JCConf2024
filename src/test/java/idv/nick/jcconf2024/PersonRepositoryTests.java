package idv.nick.jcconf2024;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:latest:///mydb");
        registry.add("spring.datasource.username", () -> "myuser");
        registry.add("spring.datasource.password", () -> "secret");
        registry.add("spring.liquibase.label-filter", () -> "v1.0,test");
    }

    @Test
    void calculate() {
        var topBySalary = personRepository.findTopBySalary();
        assertThat(topBySalary).isEqualTo(new Person("John Doe", 30, "male", 1088.99));
    }
}
