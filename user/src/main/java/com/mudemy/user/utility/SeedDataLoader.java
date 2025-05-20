package com.mudemy.user.utility;

import com.mudemy.user.models.Role;
import com.mudemy.user.models.RoleType;
import com.mudemy.user.models.User;
import com.mudemy.user.repositories.RoleRepository;
import com.mudemy.user.repositories.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Slf4j
//@Component
public class SeedDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0){

            Role role = new Role();
            role.setName(RoleType.ADMIN);
            roleRepository.save(role);

            User user = new User();
            user.setEmail("mustafa@hotmail.com");
            user.setFirstName("Mustafa");
            user.setLastName("Güler");
            user.setPassword(passwordEncoder.encode("123"));
            user.setUsername("mustafa");
            user.setFullName("mustafa güler");
            user.setPhoneNumber("1234567890");
            user.setActive(true);
            user.setProfileImageUrl("https://res.cloudinary.com/patika-dev/image/upload/v1739031274/uwbjz1yo4k04koslt0oj.jpg");
            user.setRoles(Collections.singleton(role));

            userRepository.save(user);
            log.info("User info added");
        }
    }
}
