package com.mudemy.auth.service.impl;

import com.mudemy.auth.model.AuthUser;
import com.mudemy.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not fount this email" + username));

        return new UserDetailsImpl(user);
    }
}



























