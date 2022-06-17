package capstone.fullstack.app.controller;

import capstone.fullstack.app.entity.EmployeeEntity;
import capstone.fullstack.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display a list of employees
    @GetMapping("/employees")
    public String viewEmployeePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "listemployees";
    }

    @GetMapping("/newEmployeeForm")
    public String newEmployeeForm(Model model) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        model.addAttribute("employee", employeeEntity);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employeeEntity) {
        // save employee to db
        employeeService.saveEmployee(employeeEntity);
        return "redirect:/api/employees";
    }

}
