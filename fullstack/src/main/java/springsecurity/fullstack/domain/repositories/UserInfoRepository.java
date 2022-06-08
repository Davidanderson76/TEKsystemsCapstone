package springsecurity.fullstack.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springsecurity.fullstack.domain.entities.EmployeeInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

    List<EmployeeInfo> findAllByActiveOrderByIdDesc(boolean active);

    Optional<EmployeeInfo> findByIdAndActive(Integer id, boolean active);

}
