package by.academy.it.controllers;

import by.academy.it.model.Employee;
import by.academy.it.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeJspController {
    private final EmployeeRepository repository;

    @GetMapping("/info")
    public ModelAndView employeeInfo(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", repository.findAll());
        modelAndView.addObject("principal", principal);
        modelAndView.setViewName("employees");
        return modelAndView;
    }

    @GetMapping("/self")
    public ModelAndView employeeSelfInfo(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee");
        Optional<Employee> byName = repository.findByName(principal.getName());
        byName.ifPresent(modelAndView::addObject);
        return modelAndView;
    }

}
