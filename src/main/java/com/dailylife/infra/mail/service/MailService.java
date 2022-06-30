package com.dailylife.infra.mail.service;

import com.dailylife.infra.mail.dto.SendMailRequest;

public interface MailService {

    String sendMail(SendMailRequest sendMailRequest);

}
