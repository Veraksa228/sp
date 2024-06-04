package ru.kata.spring.boot_security.demo.configs;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component

public class PostConstructClass {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;

    public PostConstructClass(PasswordEncoder passwordEncoder, UserService userService, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void addAdminAndUser() {
        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
roleService.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setName("USER");
roleService.save(roleUser);

        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        roles.add(roleUser);

        Set<Role> rolesForUser = new HashSet<>();
        rolesForUser.add(roleUser);

        User admin = new User();
        admin.setFirstName("ADMIN");

        admin.setLastName("ADMIN2");
        admin.setEmail("admin@mail.ru");
        admin.setPassword("123");
        admin.setRoles(roles);

        User user = new User();
        user.setEmail("user@mail.ru");

        user.setFirstName("USER");
        user.setLastName("USER2");
        user.setPassword("123");
        user.setRoles(rolesForUser);
        userService.add(user);
        userService.add(admin);

    }
}






