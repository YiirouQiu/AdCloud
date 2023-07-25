package org.AdCloud.ad.service;

import lombok.extern.slf4j.Slf4j;
import org.AdCloud.ad.exception.AdException;
import org.AdCloud.ad.vo.CreateUserRequest;
import org.AdCloud.ad.vo.CreateUserResponse;
import org.springframework.stereotype.Service;


public interface UserService {

    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
