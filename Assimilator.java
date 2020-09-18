import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Assimilator {

  public static void main(String[] args) {

		final String username = "phillip.n.lee90@gmail.com";
		final String password = "uufltrktsjhkorat";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("phillip.n.lee90@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("georson96@gmail.com"));
			//message.setSubject("Testing Subject");
			message.setSubject("Something Different");
			//message.setText("Resistance is futile..");
			/* message.setText("Why do Java developers wear glasses? Because they don't C#. \r\n" + 
					"\r\n" + 
					"source: http://www.jokes4us.com/peoplejokes/computerjokes.html"); */
			message.setText("Somebody stole my new Microsoft Office last week and they are going to pay! You have my Word! \r\n" + 
					"\r\n" + 
					"source: http://www.jokes4us.com/peoplejokes/computerjokes.html");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
