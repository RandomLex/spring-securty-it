package by.academy.it.controllers;

import by.academy.it.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class EmployeeJspController {
    private final EmployeeRepository repository;

    @GetMapping("/info")
    public ModelAndView employeeInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", repository.findAll());
        modelAndView.setViewName("employees");
        return modelAndView;
    }

}
