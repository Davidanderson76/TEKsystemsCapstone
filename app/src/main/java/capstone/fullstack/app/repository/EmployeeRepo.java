package capstone.fullstack.app.repository;

import capstone.fullstack.app.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByFirstName(String firstName);

    List<EmployeeEntity> findByEmail(String email);


}
