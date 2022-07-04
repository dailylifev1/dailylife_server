package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.security.SpringSecurityConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SpringSecurityConfig springSecurity;

    @Override
    @Transactional
    public User join(UserJoinRequest userJoinRequest) {
        String enPw = springSecurity.passwordEncoder().encode(userJoinRequest.getUserPassword()); // 스프링시큐리티로 pw 암호화
        userJoinRequest.setUserPassword(enPw);
        User user = userRepository.save(User.toEntity(userJoinRequest));
        return user;
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        if (userRepository.countByUserId(userLoginRequest.getUserId()) == 1) { // 입력한 id가 DB에 존재하는 경우

            User user = userRepository.findByUserId(userLoginRequest.getUserId()); // 입력한 id를 user객체에 넣어준다
            if (!springSecurity.passwordEncoder().matches(userLoginRequest.getUserPassword(), user.getUserPassword())) { // 로그인 ID가 존재는 하지만 PW가 다를경우
                throw new RuntimeException("비밀번호가 일치하지 않습니다.");
            } else return user; //로그인 ID와 PW가 일치하면 true 리턴
        }
        throw new RuntimeException("존재하지 않는 ID입니다.");
    }
}

