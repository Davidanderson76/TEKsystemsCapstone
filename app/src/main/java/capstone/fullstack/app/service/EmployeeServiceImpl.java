package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.EmployeeEntity;
import capstone.fullstack.app.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

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
}
