package com.palani.PoultryAssist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	
	@Autowired
    private JavaMailSender mailSender;
	
	
	public void sendMail(String to,String body,String subject)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		try
		{
			message.setTo(to);
			message.setText(body);
			message.setSubject(subject);
			
			mailSender.send(message);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	}

}
