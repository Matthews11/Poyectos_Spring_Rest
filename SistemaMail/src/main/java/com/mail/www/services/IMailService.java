package com.mail.www.services;

import javax.mail.MessagingException;

public interface IMailService {

	public void enviar(String tomail,String subject,String body) throws MessagingException;
}
