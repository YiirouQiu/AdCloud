package org.AdCloud.ad.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.AdCloud.ad.constant.Constants;
import org.AdCloud.ad.dao.AdUserRepository;
import org.AdCloud.ad.entity.AdUser;
import org.AdCloud.ad.exception.AdException;
import org.AdCloud.ad.service.UserService;
import org.AdCloud.ad.utils.CommonUtils;
import org.AdCloud.ad.vo.CreateUserRequest;
import org.AdCloud.ad.vo.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if (! request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        String username = request.getUsername();
        AdUser user = userRepository.findByUsername(username);
        if (user != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser createUser = new AdUser(username, CommonUtils.md5(username));
        AdUser createdUser = userRepository.save(createUser);
        return new CreateUserResponse(createdUser.getId(),
                                        createdUser.getUsername(),
                                        createdUser.getToken(),
                                        createdUser.getCreateTime(),
                                        createdUser.getUpdateTime());
    }
}
