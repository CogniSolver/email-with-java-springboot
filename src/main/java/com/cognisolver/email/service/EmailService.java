package com.cognisolver.email.service;

import com.cognisolver.email.dto.EmailPayload;

public interface EmailService {
	String sendtextEMail(EmailPayload emailPayload);
}
