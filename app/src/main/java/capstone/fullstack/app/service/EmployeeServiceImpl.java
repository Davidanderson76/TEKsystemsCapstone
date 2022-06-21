package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EmployeeEntity;
import capstone.fullstack.app.exceptions.ResourceNotFoundException;
import capstone.fullstack.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(EmployeeEntity employeeEntity) {
        this.employeeRepo.save(employeeEntity);
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        Optional<EmployeeEntity> optional = employeeRepo.findById(id);
        EmployeeEntity employeeEntity = null;
        if (optional.isPresent()) {
            employeeEntity = optional.get();
        } else {
            throw new ResourceNotFoundException("Employee with id: " + id + " not found...");
        }
        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepo.deleteById(id);
    }
}
