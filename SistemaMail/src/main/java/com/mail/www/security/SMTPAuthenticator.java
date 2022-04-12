package com.mail.www.security;

import javax.mail.PasswordAuthentication;

import org.springframework.stereotype.Component;

import com.mail.www.model.Mail;
@Component
public class SMTPAuthenticator  extends javax.mail.Authenticator {
	

        public PasswordAuthentication getPasswordAuthentication() {
        	Mail mail = new Mail();
            return new PasswordAuthentication(mail.getSenderEmail(), mail.getSenderPassword());
        }
    
}
