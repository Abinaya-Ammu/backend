package com.iniyabuilders.contact_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*") // your frontend port
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping
    public String sendEmail(@RequestBody ContactForm form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("abiammu8905@gmail.com"); // Owner's email
        message.setSubject("New Contact Form Submission: " + form.getSubject());
        message.setText("Name: " + form.getName() + "\nEmail: " + form.getEmail() + "\nPhone Number: " + form.getPhone() + "\nAddress: " + form.getSubject() + "\n\nMessage:\n" + form.getMessage());
        mailSender.send(message);
        return "Message Sent Successfully";
    }
}

class ContactForm {
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

