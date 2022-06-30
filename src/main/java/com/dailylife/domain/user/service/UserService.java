package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.entity.User;

public interface UserService {

    /**
     * ㅇㅇㅇ
     * @param
     * @returnㅇㅇㅇㅇㅇㅇㅇddddddddddddddddd
     */

    User join(UserJoinRequest userJoinRequest);

    boolean login(UserLoginRequest userLoginRequest);
}
