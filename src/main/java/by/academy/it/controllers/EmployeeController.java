package by.academy.it.controllers;

import by.academy.it.model.Employee;
import by.academy.it.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/employees", produces = "application/json")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAll(Principal principal, SecurityContextHolder sc, HttpServletRequest rq) {
//        rq.getServletContext().getAttribute()
        log.info(principal.getName());
        return repository.findAll();
    }
}
