package capstone.fullstack.app.service;

import capstone.fullstack.app.entity.UserEntity;
import capstone.fullstack.app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity save(UserRegistrationDto registrationDto);
}
