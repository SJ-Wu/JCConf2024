package idv.nick.jcconf2024;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Jcconf2024Application {

	public static void main(String[] args) {
		SpringApplication.run(Jcconf2024Application.class, args);
	}

}

@Service
@RequiredArgsConstructor
class SalaryCalculatorService {

	private final PersonRepository personRepository;

	public double calculateTotalSalary() {
		return personRepository.findAll().stream()
				.mapToDouble(Person::salary)
				.sum();
	}
}

record Person(String name, int age, String gender, double salary) {}

interface PersonRepository extends ListCrudRepository<Person, String> {

	@Query("SELECT * FROM person ORDER BY salary DESC LIMIT 1")
	Person findTopBySalary();
}