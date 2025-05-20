package com.mudemy.user.services.impl;

import com.mudemy.user.dtos.CreateUserRequest;
import com.mudemy.user.dtos.UserResponse;
import com.mudemy.user.models.User;
import com.mudemy.user.repositories.UserRepository;
import com.mudemy.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest, HttpStatus created) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        userRepository.save(user);
        return toUser(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> toUser(user))
                .toList();
    }

    private UserResponse toUser(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    private List<UserResponse> toUserList(List<User> users){
        return users.stream().map(user -> toUser(user)).toList();
    }
}























