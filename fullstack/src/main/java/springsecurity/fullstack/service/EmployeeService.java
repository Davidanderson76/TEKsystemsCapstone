package springsecurity.fullstack.service;

import org.springframework.stereotype.Service;
import springsecurity.fullstack.domain.entities.EmployeeInfo;
import springsecurity.fullstack.domain.repositories.UserInfoRepository;
import springsecurity.fullstack.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService {

    private final UserInfoRepository userInfoRepository;

    public EmployeeService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public EmployeeInfo getUser(Integer id) {
        return userInfoRepository.findByIdAndActive(id,true).orElseThrow(NotFoundException::new);
    }

    public EmployeeInfo createUser(EmployeeInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public List<EmployeeInfo> getUsers() {
        return userInfoRepository.findAllByActiveOrderByIdDesc(true);
    }

    public EmployeeInfo updateUser(Integer id, EmployeeInfo request) {
        EmployeeInfo fromDb = getUser(id);
        fromDb.setFirstName(request.getFirstName());
        fromDb.setLastName(request.getLastName());
        fromDb.setRole(request.getRole());
        fromDb.setActive(request.isActive());
        fromDb.setUpdatedAt(LocalDateTime.now());
        return userInfoRepository.save(fromDb);
    }
}
