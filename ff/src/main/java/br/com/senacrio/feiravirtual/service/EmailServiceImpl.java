package br.com.senacrio.feiravirtual.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	public static String URL = "Email de verificação:" + "\n" + "http://localhost:8080/usuario/validaEmail";
	private JavaMailSender javaMailSender;

	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(String toEmail, String subject) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);

		mailMessage.setText(URL + "?usuarioEmail=" + toEmail);

		mailMessage.setFrom("fabiano.p.martins@gmail.com");

		javaMailSender.send(mailMessage);
	}
}