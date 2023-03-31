package ru.kata.spring.boot_security.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;


@RestController
public class AuthRestController {

    @GetMapping("api/auth")
    public ResponseEntity<UserDTO> userAuth (@AuthenticationPrincipal User userAuth) {
        return ResponseEntity.ok(new UserDTO(userAuth));
    }
}
