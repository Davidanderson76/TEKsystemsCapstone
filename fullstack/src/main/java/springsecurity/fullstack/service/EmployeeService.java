package springsecurity.fullstack.service;

import springsecurity.fullstack.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

}
