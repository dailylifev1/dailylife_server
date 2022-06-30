package com.dailylife.infra.mail.service;

import com.dailylife.infra.mail.dto.SendMailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public String sendMail(SendMailRequest sendMailRequest) {

        Random rd = new Random();

        StringBuilder authKey = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            authKey.append(rd.nextInt(10));
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendMailRequest.getEmail());
        message.setSubject("인증메일입니다.");
        message.setText(authKey.toString());

        javaMailSender.send(message);
        return authKey.toString();

    }
}
