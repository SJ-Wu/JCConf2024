package idv.nick.jcconf2024;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployController {
    final EmployRepository employRepository;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        return employRepository.save(employee);
    }
}

