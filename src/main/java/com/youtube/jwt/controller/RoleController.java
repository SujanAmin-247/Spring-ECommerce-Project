package com.youtube.jwt.controller;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@RestController
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;
    @PostConstruct
    public void initRole(){
        roleService.initRole();
    }

    @GetMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role) {
        logger.info("Inside fun API:");
        return roleService.createNewRole(role);
    }
    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "This url is applicable only to admins";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "This url is applicable only to users";
    }

}
