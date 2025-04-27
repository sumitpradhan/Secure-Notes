package com.secure.notes.controller;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.User;
import com.secure.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')") // all the methods should have this role
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    UserService userService;

   // @PreAuthorize("hasRole('ROLE_ADMIN')") // this authorisation is invoke before executing the method
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUser()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update-role")
    public ResponseEntity<String> updateUserRole(@RequestParam Long userId,
                                                 @RequestParam String roleName) {
        userService.updateUserRole(userId, roleName);
        return ResponseEntity.ok("User role updated");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
