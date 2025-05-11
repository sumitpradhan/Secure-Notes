package com.secure.notes.services;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);

    User findByUsername(String username);

    Optional<User> findByEmail(String email);

    User registerUser(User newUser);
}
