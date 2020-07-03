package com.personal.portfolio.service;

import com.personal.portfolio.exception.PortfolioException;

/**
 * <h1>Mail sending service interface!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

public interface EmailService {

    /**
     * sends a mail to 'to' address,with subject 'subject' and
     * with the body text as 'text'
     * @param to the email address of the user
     * @param subject
     * @param text
     * @throws PortfolioException.MailSendingFailed custom exception
     */
    void sendSimpleMessage(String to,
                           String subject,
                           String text)throws PortfolioException.MailSendingFailed;
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        String ...templateModel);
}
