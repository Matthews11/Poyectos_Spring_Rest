package com.mail.www.model;

public class Mail {
	 
    private String senderEmail ="jaredpineda033@gmail.com"; 
    private String senderPassword="GetContrasena2022" ;
    private String emailSMTPserver = "smtp.gmail.com";
    private String emailServerPort = "587"; 
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderPassword() {
		return senderPassword;
	}
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	public String getEmailSMTPserver() {
		return emailSMTPserver;
	}
	public void setEmailSMTPserver(String emailSMTPserver) {
		this.emailSMTPserver = emailSMTPserver;
	}
	public String getEmailServerPort() {
		return emailServerPort;
	}
	public void setEmailServerPort(String emailServerPort) {
		this.emailServerPort = emailServerPort;
	}
	 
    
}
