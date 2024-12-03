package com.cognisolver.email.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cognisolver.email.dto.EmailPayload;
import com.cognisolver.email.service.EmailService;

@Service(value = "emailService")
public class EmailServiceImpl implements EmailService {

	private JavaMailSender mailSender;

	public EmailServiceImpl(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Override
	public String sendtextEMail(EmailPayload emailPayload) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Email testing from Java SpringBoot");
		message.setFrom(fromEmail);
		message.setTo(emailPayload.getRecepientEmail());
		message.setText(emailPayload.getEmailMessage());
		mailSender.send(message);

		return "Mail sent successfully";
	}

}
