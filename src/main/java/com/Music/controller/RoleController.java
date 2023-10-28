package com.Music.controller;

import com.Music.model.Role;
import com.Music.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/{email}")
    public String addRole(@PathVariable String email, @RequestBody Role role) {

        return roleService.addRole(role, email);
    }
}
