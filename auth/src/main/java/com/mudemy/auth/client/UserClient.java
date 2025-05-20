package com.mudemy.auth.client;

import com.mudemy.auth.dto.UserProfileRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
public interface UserClient {

    @PostMapping("/api/users")
    void createUserProfile(@RequestBody UserProfileRequest request);
}
