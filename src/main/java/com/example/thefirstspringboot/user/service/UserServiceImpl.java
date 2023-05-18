package com.example.thefirstspringboot.user.service;

import com.example.thefirstspringboot.security.dto.RegisterRequestDto;
import com.example.thefirstspringboot.user.entity.User;
import com.example.thefirstspringboot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isTakenUsername(String username) {
        return false;
    }

    @Override
    public boolean isTakenEmail(String email) {
        return false;
    }

    @Override
    public User createUser(RegisterRequestDto data) {
        User user = new User();

        user.setUsername(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        return repository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getCustomers() {
        return null;
    }

    @Override
    public void deleteUserByUsername(String username) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User getProfile() {
        return null;
    }

    @Override
    public boolean blockUser(String username) {
        return false;
    }

    @Override
    public void deleteByUsername(String username) {

    }
}
