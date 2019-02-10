package com.qa.tester;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import com.qa.base.testbase;
import com.qa.client.RestClient;

import io.restassured.response.Response;

import org.apache.commons.mail.*;
import org.apache.http.client.methods.CloseableHttpResponse;


public class sendAnEmail extends testbase {
	
	testbase testbases;
	String serviceURL;
	String apiURL;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeAbleHttpResponse;
	String userPerPage;
	String totalpagesInResponse;
	Response resp;
	
	@Test
	public void f()  throws EmailException {
	  
	  
	  
	// Create the attachment
	  /*EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath("C:\\Users\\Suvneet.Singh\\eclipse-workspace\\BDD_final\\target\\surefire-reports\\Extent.html");
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("TestNG report");
	  attachment.setName("Suvneet");

	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
	  email.setHostName("mail.myserver.com");
	  email.addTo("jdoe@somewhere.org", "John Doe");
	  email.setFrom("me@apache.org", "Me");
	  email.setSubject("TestNG report");
	  email.setMsg("TestNG report");

	  // add the attachment
	  email.attach(attachment);

	  // send the email
	  email.send();*/
	  
	  /*HtmlEmail email = new HtmlEmail();
	  email.setHostName("localhost");
	  email.addTo("test@mail.com", "Test");
	  email.setFrom("testapp@mail.com", "Test App");
	  email.setSubject("Test message");
	  email.setHtmlMsg("<div style='font-size: 20px; color: green;'>This is html email</div>");

	  EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath(pdfPath);
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  email.attach(attachment);

	  email.send();*/
	  
	    EmailAttachment attachment = new EmailAttachment();
	    //HtmlEmail email = new HtmlEmail();
	    attachment.setPath("C:\\Users\\Suvneet.Singh\\eclipse-workspace\\BDD_final\\target\\surefire-reports\\Extent.html");
	    attachment.setDisposition(EmailAttachment.ATTACHMENT);
	    attachment.setDescription("Attachment");
	    attachment.setName("Suvneet");
	    try {
	    	//HtmlEmail email = new HtmlEmail();
	    	 MultiPartEmail email = new MultiPartEmail();
	        //email.setDebug(debug);
	        email.setHostName("smtp.gmail.com");
	        //email.setHostName("outlook.office365.com");
	        //String port = email.getSmtpPort();
	        //System.out.println(port);
	        email.addTo(prop.getProperty("ToUserID"));
	        email.setFrom(prop.getProperty("FromUserid"));
	        email.setAuthentication(prop.getProperty("FromUserid"), prop.getProperty("password"));
	        email.setSubject("TestNG results");
	        //email.setHtmlMsg("<div style='font-size: 20px; color: green;'>This is html email</div>");
	        email.setMsg("TestNG results");
	        email.setSSL(true);
	        email.attach(attachment);
	        //email.attach(attachmentLogs);
	        email.send();
	    } catch (EmailException e) {
	        System.out.println(e.getMessage());
	    }
  }
}
