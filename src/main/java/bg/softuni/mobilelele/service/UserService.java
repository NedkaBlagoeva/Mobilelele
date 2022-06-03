package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserLoginDto;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isLogged (UserLoginDto userLoginDto){
        return true;
    }
}
