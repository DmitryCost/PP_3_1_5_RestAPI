package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {
    private final UserService userService;
    private  final RoleService roleService;
    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsersTable () {
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("api/admin/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleService.getListRoles());
    }
    @PostMapping()
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        User user = userService.findByEmail(userDTO.getEmail());
        return ResponseEntity.ok(new UserDTO(user));
    }

    @PatchMapping()
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO);
        userService.update(user);
        return ResponseEntity.ok(new UserDTO(user));
    }
    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
