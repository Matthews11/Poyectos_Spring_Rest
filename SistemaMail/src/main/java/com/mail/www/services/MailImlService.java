package com.mail.www.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.mail.www.model.Mail;
import com.mail.www.security.SMTPAuthenticator;

@Service
public class MailImlService implements IMailService {

	@Override
	public void enviar(String tomail, String subject, String body) throws MessagingException {

		Properties props = new Properties();
		Mail mail = new Mail();
		props.put("mail.smtp.user", mail.getSenderEmail());
		props.put("mail.smtp.host", mail.getEmailSMTPserver());
		props.put("mail.smtp.port", mail.getEmailServerPort());
		props.put("mail.smtp.transport.protocols", "smtp");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", mail.getEmailServerPort());
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		SecurityManager security = System.getSecurityManager();
		SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);

		Message msg = new MimeMessage(session);

		msg.setText(body);
		msg.setSubject(subject);
		msg.setFrom(new InternetAddress(tomail));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getSenderEmail()));
		Transport.send(msg);
		System.out.println("se envio successfully");

	}

}
