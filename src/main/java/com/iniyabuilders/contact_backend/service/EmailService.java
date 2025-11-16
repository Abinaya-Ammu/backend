package com.iniyabuilders.contact_backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.iniyabuilders.contact_backend.model.MailRequest;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(MailRequest request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("abiammu8905@gmail.com"); // owner email
        msg.setSubject("New Contact Form: " + (request.getSubject() == null ? "(no subject)" : request.getSubject()));
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(request.getName()).append("\n");
        sb.append("Email: ").append(request.getEmail()).append("\n\n");
         sb.append("Phone Number: ").append(request.getPhone()).append("\n\n");
        sb.append("Address: ").append(request.getSubject()).append("\n\n");
        sb.append("Message:\n").append(request.getMessage()).append("\n");
        msg.setText(sb.toString());
        mailSender.send(msg);
    }
}

