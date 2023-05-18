package com.example.thefirstspringboot.security.controller;

import com.example.thefirstspringboot.common.controller.BaseController;
import com.example.thefirstspringboot.security.dto.LoginRequestDto;
import com.example.thefirstspringboot.security.dto.LoginResponseDto;
import com.example.thefirstspringboot.security.jwt.JWTService;
import com.example.thefirstspringboot.user.entity.User;
import com.example.thefirstspringboot.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponseDto getTokenForAuthenticatedUser(@Valid @RequestBody LoginRequestDto authRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authentication.isAuthenticated()) {
            String jwtToken = jwtService.generateToken(authRequest.getUsername());
            return LoginResponseDto.builder()
                    .accessToken(jwtToken)
                    .build();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @PostMapping("/register")
    public LoginResponseDto register(@RequestBody LoginRequestDto authRequest) {
        Optional<User> theUser = userRepository.findByUsername(authRequest.getUsername());
        if (theUser.isPresent()){
            throw new RuntimeException("A user with " + authRequest.getUsername() + " already exists");
        }
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        userRepository.save(user);

        String jwtToken = jwtService.generateToken(authRequest.getUsername());
        return LoginResponseDto.builder()
                .accessToken(jwtToken)
                .build();
    }
}
