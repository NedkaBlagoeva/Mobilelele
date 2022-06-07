package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.User;
import bg.softuni.mobilelele.model.dto.UserLoginDto;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private CurrentUser currentUser;

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDto userLoginDto) {
        Optional<User> userOpt = userRepository.findByUsername(userLoginDto.getUsername());
        if (userOpt.isEmpty()) {
            LOGGER.info("No user with username {} found", userLoginDto.getUsername());
            return false;
        }

        var rawPassword = userLoginDto.getPassword();
        var encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(User user) {
        currentUser.
                setLoggedIn(true);
        currentUser.
                setName(user.getUsername());
    }

    public void logout() {
        currentUser.
                clear();
    }
}
