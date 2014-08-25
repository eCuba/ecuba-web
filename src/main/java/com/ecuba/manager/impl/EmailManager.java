package com.ecuba.manager.impl;

import com.ecuba.domain.User;
import com.ecuba.manager.IEmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.integration.mail.MailSendingMessageHandler;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by rolando on 2014-08-23.
 */

@Service("emailManager")
public class EmailManager implements IEmailManager {

	private JavaMailSender mailSender;

	@Autowired
	public void setMailSender(@Qualifier("mailSender")JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(User user) {


		MimeMessage message = mailSender.createMimeMessage();

// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getUsername());
			helper.setFrom("rolo@ecuba.com");
			helper.setSubject("ecuba-app");
			helper.setText("test");

// let's attach the infamous windows Sample file (this time copied to c:/)
			FileSystemResource file = new FileSystemResource(new File("/Volumes/Data/foto.jpg"));
			helper.addAttachment("CoolImage.jpg", file);

			mailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}


	}
}
