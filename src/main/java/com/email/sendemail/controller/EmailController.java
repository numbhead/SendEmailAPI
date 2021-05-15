package com.email.sendemail.controller;

import com.email.sendemail.model.Email;
import com.email.sendemail.model.Result;
import com.email.sendemail.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {
    
    @Autowired
    EmailService emailService;

    @Value("${spring.mail.username}")
    private String fromAddress;

    @PostMapping(value="/sendemail", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Result postBody(@RequestBody Email email) {
        boolean sendEmail = emailService.SendEmail(fromAddress, email.getToAddress(), email.getSubject(), email.getBody());
        Result res = new Result();
        if(sendEmail){
            res.setMessage("Email Sent Succesfully");
            res.setErrorMessage("");
            res.setSuccessFlag(true);
        }
        else {
            res.setMessage("Email Sending Unsuccesfull!");
            res.setErrorMessage("Exception in sending email");
            res.setSuccessFlag(false);
        }

        return res;
    }

}
