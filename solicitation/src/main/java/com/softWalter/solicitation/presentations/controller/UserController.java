package com.softWalter.solicitation.presentations.controller;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.usecases.UseCaseUserService;
import com.softWalter.solicitation.presentations.controller.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "softwalter/v1/users")
public class UserController {

    @Autowired
    private UseCaseUserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User createUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(
            @PathVariable(name = "id") Long id,
            @RequestBody User user) {
        user.setId(id);
        User updateUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping()
    public ResponseEntity <List<User>> findAll() {
        List<User> users = userService.listUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/login")
    public ResponseEntity <User> login(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
