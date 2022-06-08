package springsecurity.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecurity.fullstack.entity.Employee;
import springsecurity.fullstack.repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepo.save(employee);
    }
}
