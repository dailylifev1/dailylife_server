package com.dailylife.domain.heart.service;



import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.heart.repository.HeartRepository;
import com.dailylife.domain.reply.entity.Reply;
import org.springframework.stereotype.Service;

@Service
public interface HeartService {

    boolean heartPlus(HeartStateRequest heartStateRequest);



}
