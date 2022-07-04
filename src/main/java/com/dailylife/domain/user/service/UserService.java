package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.entity.User;

public interface UserService {

    User join(UserJoinRequest userJoinRequest);

    User login(UserLoginRequest userLoginRequest);

}
