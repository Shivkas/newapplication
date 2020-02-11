
package Test;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {
	//public static void main (String[] args) {
	//	MailSender.send("shivika.beec.16@acharya.ac.in", "rpas*1018", "prtkraj03@gmail.com", "<3 <3","Congratulation..you too have logged in into shivika's heart");
	//}
	public static void SendMailComplete(String to, String UserId, int password) {
		MailSender.send("shivika.beec.16@acharya.ac.in", "rpas*1018", to, "Registration Successful","Congratulations !!!!!!!!!!!!!!!! Your registration has been successfully done with this user id:::"+UserId+" & password is::"+password);
				
	}

	public static void send(final String from, final String password, String to, String sub, String msg) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg); // send message

			Transport.send(message);

			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
