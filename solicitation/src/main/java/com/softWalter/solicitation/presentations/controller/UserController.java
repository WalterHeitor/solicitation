package com.softWalter.solicitation.presentations.controller;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestSolicitation;
import com.softWalter.solicitation.domain.usecases.UseCaseUserService;
import com.softWalter.solicitation.domain.usecases.model.PageModel;
import com.softWalter.solicitation.domain.usecases.model.PageRequestModel;
import com.softWalter.solicitation.presentations.controller.dto.UserLoginDTO;
import com.softWalter.solicitation.presentations.controller.dto.UserUpdateRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "softwalter/v1/users")
public class UserController {

    @Autowired
    private UseCaseUserService userService;
    @Autowired
    private UseCaseRequestSolicitation useCaseRequestSolicitation;

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
    public ResponseEntity<PageModel<User>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        PageRequestModel pageRequestModel = new PageRequestModel(page, size);
        PageModel<User> userPageModel = userService.listAllOnLaziMode(pageRequestModel);
        return ResponseEntity.status(HttpStatus.OK).body(userPageModel);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        User user = userService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping(value = "/{id}/requestSolicitation")
    public ResponseEntity<List<RequestSolicitation>> listRequestSolicitationById(
            @PathVariable(name = "id") Long id) {
        List<RequestSolicitation> requestSolicitations =
                useCaseRequestSolicitation.findAllByOwnerId(id);
        return ResponseEntity.status(HttpStatus.OK).body(requestSolicitations);
    }
    @PatchMapping("role/{id}")
    public ResponseEntity<?> updateRole(
            @PathVariable(name = "id") Long id,
            @RequestBody UserUpdateRoleDTO userUpdateRoleDTO
    ) {

        User user = new User();
        user.setId(id);
        user.setRole(userUpdateRoleDTO.getRole());
        userService.updateRole(user);
        return ResponseEntity.ok(user);
    }
}
