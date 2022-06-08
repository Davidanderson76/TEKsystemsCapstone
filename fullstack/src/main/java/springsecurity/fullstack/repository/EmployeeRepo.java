package springsecurity.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.fullstack.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {



}
