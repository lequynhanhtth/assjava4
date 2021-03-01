package com.poly.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {
	public static void sendText(String from, String to, String password, String subject, String text)
			throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;

		// Step1: setup Mail Server
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		// Step2: get Mail Session
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // Thay abc bằng địa
																						// chỉ người nhận

		// Bạn có thể chọn CC, BCC
//		    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail
		mailMessage.setSubject(subject, "utf-8");
		mailMessage.setText(text, "utf-8");

		// Step3: Send mail
		Transport transport = getMailSession.getTransport("smtp");

		// Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail
		// của bạn
		transport.connect("smtp.gmail.com", from, password);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
}
