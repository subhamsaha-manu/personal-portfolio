package com.personal.portfolio.service;

import com.personal.portfolio.exception.PortfolioException;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text)throws PortfolioException.MailSendingFailed;
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        String ...templateModel);
}
