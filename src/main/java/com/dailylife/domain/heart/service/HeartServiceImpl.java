package com.dailylife.domain.heart.service;

import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.entity.Heart;
import com.dailylife.domain.heart.repository.HeartRepository;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.jwt.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService{

    private final HeartRepository heartRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;


    @Override
    public boolean heartPlus(HeartStateRequest heartStateRequest) {
        Reply reply = new Reply();
        System.out.println("1");
        reply.setReplyNum(heartStateRequest.getRno());
        System.out.println("2");
        User user = userRepository.findByUserId(jwtService.getLoginId());
        heartStateRequest.setUno(user.getUserNum());
        System.out.println("3");
        heartStateRequest.setHeartState(1L);
        Heart heart = heartRepository.save(Heart.toEntity(heartStateRequest, reply));
        System.out.println("4");
        return true;
    }

    @Override
    public boolean hearMinus(HeartStateRequest heartStateRequest) {
        return false;
    }
}
