package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User join(UserJoinRequest userJoinRequest) {
        User user = userRepository.save(User.toEntity(userJoinRequest));
        user.setUserPassword("ddd");
        return user;
    }

}
