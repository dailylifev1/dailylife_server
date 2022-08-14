package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.dto.UserModifyRequest;
import com.dailylife.domain.user.dto.UserPagination;
import com.dailylife.domain.user.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User join(UserJoinRequest userJoinRequest);

    User login(UserLoginRequest userLoginRequest);

    User modify(UserModifyRequest userModifyRequest);

    String modifyProfileImg(MultipartFile img) throws IOException;

    void quit(Long userNum);

    User getDetails(Long userNum);

    List<User> findUser(UserPagination userPagination);


}
