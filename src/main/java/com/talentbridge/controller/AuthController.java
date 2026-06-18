package com.talentbridge.controller;
import com.talentbridge.jwt.JwtUtil;
import com.talentbridge.model.User;
import com.talentbridge.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Authentication APIs",
    description = "User registration and login"
)
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @Operation(summary = "Login and generate JWT token")
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedInUser =
            authService.login(
                user.getUsername(),
                    user.getPassword());

        if (loggedInUser != null) {
            return jwtUtil.generateToken(
                loggedInUser.getUsername());
        }
            return "Invalid Username or Password";
    }
}