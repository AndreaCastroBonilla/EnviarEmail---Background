package enviar.email.main;

public class Main {

	public static void main(String[] args) {
//		try {
//			Email email = new SimpleEmail();
//			email.setHostName("smtp.gmail.com");
//			email.setSmtpPort(465);
//			
//			email.setAuthenticator(new DefaultAuthenticator("username", "password"));
//			email.setSSLOnConnect(true);
//			
//			email.setFrom("dad.iesdpm@gmail.com");
//			email.setSubject("TestMail");
//			email.setMsg("This is a test mail ... :-)");
//			email.addTo("andreacastrobonilla@gmail.com");
//			email.send();
//		} catch (EmailException e) {
//			e.getStackTrace();
//		}

		EnviarEmailApp.main(args);
	}

}
