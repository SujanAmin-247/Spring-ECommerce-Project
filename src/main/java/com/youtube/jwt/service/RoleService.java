package com.youtube.jwt.service;

import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;
    public Role createNewRole(Role role) {
        logger.info("Creating a new role: {}", role.getRoleName());
        return roleDao.save(role);
    }

    public void initRole() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Role for administration");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Role for normal User");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword("admin@pass");
        Set<Role> roles= new HashSet<>();
        roles.add(adminRole);
        adminUser.setRole(roles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserName("SujanAmin");
        user.setUserFirstName("Sujan");
        user.setUserLastName("Amin");
        user.setUserPassword("admin@pass");
        Set<Role> roles2= new HashSet<>();
        roles2.add(userRole);
        user.setRole(roles2);
        userDao.save(user);

    }

}
