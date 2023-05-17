package com.example.thefirstspringboot.auth.service;

import com.example.thefirstspringboot.auth.dto.LoginRequestDto;
import com.example.thefirstspringboot.auth.dto.LoginResponseDto;
import com.example.thefirstspringboot.auth.dto.RegisterRequestDto;
import com.example.thefirstspringboot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.thefirstspringboot.user.entity.User;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto register(RegisterRequestDto request) {
        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return LoginResponseDto.builder()
                .accessToken(jwtToken)
                .build();
    }

    public LoginResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return LoginResponseDto.builder()
                .accessToken(jwtToken)
                .build();
    }
}