package springsecurity.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springsecurity.fullstack.service.EmployeeService;

@Controller
@RequestMapping("/account")
public class EmployeeController {

    // display list of employees
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public String viewEmployeePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "employees";
    }

}
