package capstone.fullstack.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        var allEmployees = this.employeeService.getAllEmployees();
        assertEquals(allEmployees, employeeService.getAllEmployees());

    }

    @Test
    void saveEmployee() {
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
    }
}