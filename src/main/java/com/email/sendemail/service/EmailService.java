package com.email.sendemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean SendEmail(String fromAddress, String toAddress, String subject, String body)  {
        boolean flag=false;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toAddress);
        msg.setSubject(subject);
        msg.setText(body);
        try{
            javaMailSender.send(msg);
            flag=true;
        }
        catch(Exception ex){
            flag=false;
        }
        
        return flag;
    }
    
}
