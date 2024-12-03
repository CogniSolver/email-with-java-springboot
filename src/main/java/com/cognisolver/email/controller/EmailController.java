package com.cognisolver.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognisolver.email.dto.EmailPayload;
import com.cognisolver.email.service.EmailService;

@RestController
@RequestMapping(value = "email-api")
public class EmailController {

	private EmailService emailService;

	public EmailController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	@PostMapping(value = "/text")
	public ResponseEntity<String> sendTextEmail(@RequestBody EmailPayload emailPayload) {
		String successMessage = emailService.sendtextEMail(emailPayload);
		return new ResponseEntity<String>(successMessage, HttpStatus.OK);
	}

}
