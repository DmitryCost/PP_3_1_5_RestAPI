package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceIml implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceIml(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> getListRoles () {
        return roleRepository.findAll();
    }
}
