package com.example.thefirstspringboot.user.service;

import com.example.thefirstspringboot.auth.dto.RegisterRequestDto;
import com.example.thefirstspringboot.user.entity.User;

import java.util.List;

public interface UserService {
    boolean isTakenUsername(String username);

    boolean isTakenEmail(String email);

    User createUser(RegisterRequestDto dto);

    List<User> getUsers();

    List<User> getCustomers();

    void deleteUserByUsername(String username);

    User getUserByUsername(String username);

//    User updateUser(UpdateUserDto dto);

    User getProfile();

    boolean blockUser(String username);

//    void changePassword(ChangePasswordDto dto);

    void deleteByUsername(String username);
}
