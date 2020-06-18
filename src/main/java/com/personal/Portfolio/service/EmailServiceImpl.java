package com.personal.portfolio.service;


import com.personal.portfolio.exception.EntityType;
import com.personal.portfolio.exception.ExceptionType;
import com.personal.portfolio.exception.PortfolioException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Log4j2
@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public SimpleMailMessage template;

    public void sendSimpleMessage(String to, String subject, String text)throws PortfolioException.MailSendingFailed {
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        } catch (MailException exception) {
            log.error("Mail could not be sent ",exception.getStackTrace());
            throw new PortfolioException.MailSendingFailed("Mail could not be sent ");
        }
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to,
                                               String subject,
                                               String ...templateModel) {
        String text = String.format(template.getText(), templateModel);
        sendSimpleMessage(to, subject, text);
    }

    public RuntimeException exceptions(EntityType entityType,ExceptionType exceptionType,String...args){
        return PortfolioException.throwsException(entityType,exceptionType,args);
    }
}
