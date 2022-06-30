package com.dailylife.infra.mail.controller;

import com.dailylife.infra.mail.dto.SendMailRequest;
import com.dailylife.infra.mail.service.MailServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.regex.Pattern;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/mails")
public class MailController {

    private final MailServiceImpl mailService;

    @ApiOperation(value = "메일을 보냅니다" , notes = "특정 메일로 6자리의 랜덤값을 보냅니다")
    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@Valid @RequestBody SendMailRequest sendMailRequest , HttpSession session){
        session.setAttribute("mailCertification" ,mailService.sendMail(sendMailRequest));
        return ResponseEntity.ok("메일이 전송되었습니다.");
    }






}
