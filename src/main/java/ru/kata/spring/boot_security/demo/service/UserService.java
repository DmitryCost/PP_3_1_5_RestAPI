package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.DTO.UserDTO;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    void save(UserDTO userDTO);
    List<UserDTO> findAll();
    User findById(Long id);
    void delete(Long id);
    void update(User user);
    User findByEmail(String email);
}
