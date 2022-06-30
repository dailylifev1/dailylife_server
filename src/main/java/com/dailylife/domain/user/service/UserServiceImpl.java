package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User join(UserJoinRequest userJoinRequest) {
        User user = userRepository.save(User.toEntity(userJoinRequest));
        return user;
    }

    @Override
    public boolean login(UserLoginRequest userLoginRequest) {
        if (userRepository.countByUserName(userLoginRequest.getUserId()) == 1) { // 입력한 id가 DB에 존재하는 경우
            User user = userRepository.findByUserName(userLoginRequest.getUserId()); // 입력한 id를 user객체에 넣어준다
            if (!user.getUserPassword().equals(userLoginRequest.getUserPassword())) { // 로그인 ID가 존재는 하지만 PW가 다를경우
                return false;
            } else return true; //로그인 ID와 PW가 일치하면 true 리턴
        }
        return false; // 입력한 id가 DB에 존재하지 않는경우 false 리턴
    }
}

