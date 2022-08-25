package pl.britenet.springbootaugustcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.springbootaugustcampus.model.LoginCredentials;
import pl.britenet.springbootaugustcampus.model.LoginResponse;
import pl.britenet.springbootaugustcampus.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public LoginResponse performLogin(@RequestBody LoginCredentials loginCredentials) {
        return this.authService.login(loginCredentials);
    }

    @GetMapping
    public boolean checkLoggedIn(@RequestHeader("Authorization") String token) {
        return this.authService.isLoggedIn(token);
    }
}
