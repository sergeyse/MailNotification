package is.glerskalinn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.MessageBody;
import microsoft.exchange.webservices.data.ServiceLocalException;
import microsoft.exchange.webservices.data.Task;
import microsoft.exchange.webservices.data.WebCredentials;


public class MailerGS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
		
		ExchangeCredentials credentials = new WebCredentials("xxx", "xx");
		service.setCredentials(credentials);
		
		
		try {
			service.setUrl(new URI("https://xxx.xx.xx/ews/Exchange.asmx"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	EmailMessage msg= null;
		try {
			msg = new EmailMessage(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSubject("Hello world3!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			msg.setBody(MessageBody.getMessageBodyFromText("Sent using the EWS Managed API."));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.getToRecipients().add("xxxxxx@xxxxxxx.xx");
		} catch (ServiceLocalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Send ! ");
		
		Task task = null;
		try {
			task = new Task(service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			task.setSubject("Task to test in JAVA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			task.setBody(MessageBody.getMessageBodyFromText("Test body from JAVA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			task.setStartDate(new Date(2015-1900,5-1,20,17,00));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			task.save();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}

}
