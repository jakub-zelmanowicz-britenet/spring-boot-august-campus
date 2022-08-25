package pl.britenet.springbootaugustcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campus.model.User;
import pl.britenet.campus.service.UserService;
import pl.britenet.springbootaugustcampus.model.LoginCredentials;
import pl.britenet.springbootaugustcampus.model.LoginResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final Map<String, Integer> loggedInTokens;

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
        this.loggedInTokens = new HashMap<>();
    }

    public LoginResponse login(LoginCredentials loginCredentials) {
        Optional<User> oUser = this.userService.getUser(loginCredentials.getUsername(),
                loginCredentials.getPassword());

        if (oUser.isPresent()) {
            String token = UUID.randomUUID().toString();
            int userId = oUser.get().getId();

            this.loggedInTokens.put(token, userId);

            return new LoginResponse(token, userId);
        }
        throw new IllegalStateException("Invalid credentials");
    }

    public boolean isLoggedIn(String token) {
        return this.loggedInTokens.containsKey(token);
    }

}
