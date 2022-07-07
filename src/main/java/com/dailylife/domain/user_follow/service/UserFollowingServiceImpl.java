package com.dailylife.domain.user_follow.service;

import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.domain.user_follow.dto.UserFollowingRequest;
import com.dailylife.domain.user_follow.entity.UserFollow;
import com.dailylife.domain.user_follow.repository.UserFollowingRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserFollowingServiceImpl implements UserFollowingService{

    private final UserFollowingRepository userFollowRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public UserFollow following(UserFollowingRequest userFollowRequest) {

        try{
          userRepository.findByUserNum(userFollowRequest.getFollowNum()).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("유저를 찾을수 없습니다.");
        }

        User user = userRepository.findByUserId(jwtService.getLoginId());

        return userFollowRepository.save(UserFollow.toEntity(userFollowRequest,user));

    }

    @Override
    public List<UserFollow> getFollower() {

        User user = userRepository.findByUserId(jwtService.getLoginId());
        System.out.println(user.getUserNum());

        return userFollowRepository.findByFollowNum(user.getUserNum()).orElseThrow(RuntimeException::new);

    }

}
