package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EmployeeEntity;
import capstone.fullstack.app.exceptions.ResourceNotFoundException;
import capstone.fullstack.app.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class EmployeeServiceImplTest {

    // auto wiring in the service that I plan to test
    @Autowired
    private EmployeeService employeeService;

    // create a mock implementation of the employee repo
    @MockBean
    private EmployeeRepo employeeRepo;

    @Test
    @DisplayName("Test getAllEmployees Success")
    void getAllEmployees() {
        // Setup our mock repo
        EmployeeEntity employee1 = new EmployeeEntity(1L, "David", "Anderson", "test@email.com");
        EmployeeEntity employee2 = new EmployeeEntity(2L, "Brian", "Larson", "test2@email.com");
        doReturn(Arrays.asList(employee1, employee2)).when(employeeRepo).findAll();

        // Execute the service
        List<EmployeeEntity> employees = employeeService.getAllEmployees();

        // Assert the response
        Assertions.assertEquals(2, employees.size(), "findAll should return 2 employees");
    }

    @Test
    @DisplayName("Test saveEmployee Success")
    void saveEmployee() {
        // Setup our mock entity
        EmployeeEntity employeeEntity = new EmployeeEntity(1L, "David", "Anderson", "test@email.com");
        doReturn(employeeEntity).when(employeeRepo).save(any());

        // Execute the service call
        employeeService.saveEmployee(employeeEntity);

        // Assert the response
        Assertions.assertNotNull(employeeEntity, "The saved employee should NOT be null");

    }

    @Test
    @DisplayName("Test getEmployeeById Success")
    void getEmployeeById() {
        // set up mock employee
        EmployeeEntity employeeEntity = new EmployeeEntity(1L, "David", "Anderson", "test@email.com");
        doReturn(Optional.of(employeeEntity)).when(employeeRepo).findById(1l);

        // calling the service
        Optional<EmployeeEntity> returnedEmployee = Optional.ofNullable(employeeService.getEmployeeById(Long.valueOf(1)));

        // asserting the response
        Assertions.assertTrue(returnedEmployee.isPresent(), "Employee should  be found");
    }

    @Test
    @DisplayName("Test updateEmployee Success")
    void updateEmployee() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1L, "David", "Anderson", "test@email.com");

//        Optional<EmployeeEntity> optional = employeeRepo.findById(id);
//        EmployeeEntity employeeEntity = null;
//        if (optional.isPresent()) {
//            employeeEntity = optional.get();
//        } else {
//            throw new ResourceNotFoundException("Employee with id: " + id + " not found...");
//        }
//        return employeeEntity;
    }
//
//    @Test
//    @DisplayName("Test deleteEmployeeById Success")
//    void deleteEmployeeById() {
//    }
}