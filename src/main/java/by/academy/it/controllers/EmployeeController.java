package by.academy.it.controllers;

import by.academy.it.model.Employee;
import by.academy.it.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employees", produces = "application/json")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAll() {
        return repository.findAll();
    }
}
