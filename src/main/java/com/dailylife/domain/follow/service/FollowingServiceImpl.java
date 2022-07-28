package com.dailylife.domain.follow.service;

import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.domain.follow.dto.FollowingRequest;
import com.dailylife.domain.follow.entity.Follow;
import com.dailylife.domain.follow.repository.FollowingRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class FollowingServiceImpl implements FollowingService {

    private final FollowingRepository userFollowRepository;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Follow following(FollowingRequest userFollowRequest) {

        try{
          userRepository.findByUserNum(userFollowRequest.getFollowNum()).get();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("유저를 찾을수 없습니다.");
        }

        User user = userRepository.findByUserId(jwtService.getLoginId());

        return userFollowRepository.save(Follow.toEntity(userFollowRequest,user));

    }


    @Override
    @Transactional
    public void unfollowing(FollowingRequest followingRequest) {

        User user = userRepository.findByUserId(jwtService.getLoginId());
         userFollowRepository.deleteByFollowNum(followingRequest.getFollowNum());

    }

        @Override
        @Transactional
        public List<Follow> getFollow() {
            User user = userRepository.findByUserId(jwtService.getLoginId());
        return userFollowRepository.findByUser(user).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public List<Follow> getFollower() {
        User user = userRepository.findByUserId(jwtService.getLoginId());
        return userFollowRepository.findByFollowNum(user.getUserNum()).orElseThrow(RuntimeException::new);
    }


}
