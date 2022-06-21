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

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employeeEntity);
        return "update_employee";
    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") EmployeeEntity employeeEntity, Model model) {
        // get student from database by id
        EmployeeEntity existingEmployee = employeeService.getEmployeeById(id);

        existingEmployee.setFirstName(employeeEntity.getFirstName());
        existingEmployee.setLastName(employeeEntity.getLastName());
        existingEmployee.setEmail(employeeEntity.getEmail());
        // save updated student object
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/api/employees";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        // call delete from service
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/api/employees";
    }


}
