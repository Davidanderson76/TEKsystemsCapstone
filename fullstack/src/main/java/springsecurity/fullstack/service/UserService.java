package springsecurity.fullstack.service;



import org.springframework.security.core.userdetails.UserDetailsService;
import springsecurity.fullstack.UserRegistrationDto;
import springsecurity.fullstack.entity.User;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}


