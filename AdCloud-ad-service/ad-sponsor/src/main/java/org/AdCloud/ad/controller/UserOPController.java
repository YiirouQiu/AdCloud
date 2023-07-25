package org.AdCloud.ad.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.AdCloud.ad.exception.AdException;
import org.AdCloud.ad.service.UserService;
import org.AdCloud.ad.vo.CreateUserRequest;
import org.AdCloud.ad.vo.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserOPController {

    private final UserService userService;

    @Autowired
    public UserOPController(UserService userService) {
        this.userService = userService;
    }

    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: createUser() -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
