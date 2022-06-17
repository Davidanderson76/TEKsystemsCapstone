package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeEntity> getAllEmployees();

    void saveEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity getEmployeeById(Long id);

    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
}
