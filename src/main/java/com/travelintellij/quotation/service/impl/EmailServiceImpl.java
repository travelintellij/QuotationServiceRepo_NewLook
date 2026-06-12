package com.travelintellij.quotation.service.impl;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.travelintellij.quotation.dto.EmailMessageVO;
import com.travelintellij.quotation.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import freemarker.cache.WebappTemplateLoader;
import freemarker.core.Configurable;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



@Service
public class EmailServiceImpl {

	
	@Autowired
	private JavaMailSender mailSender;



	@Value("${email.client.from}")
	private String systemEmailFrom;

	@Value("${email.notify.communication.email}")
	private String emailNotifyBcc;
	
	@Value("${b2b.email.from}")
	private String b2BEmailFrom;


	 @Autowired
	 private Configuration freemarkerConfig;
	 
	@Value("${all.email.notify.communication.active}")
	private boolean emailNotifyActive;

	 
    /**
     * This method will send compose and send the message 
     * */
    public void sendMail(String to, String subject, String body) 
    {
    	if(emailNotifyActive) {
    		SimpleMailMessage message = new SimpleMailMessage();
    		message.setFrom(systemEmailFrom);
    		message.setTo(to);
    		message.setSubject(subject);
    		message.setText(body);
    		mailSender.send(message);
    	}
    }
	  
	    /**
	     * This method will send a pre-configured message
	     * 
	    public void sendPreConfiguredMail(String message) 
	    {
	        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
	        mailMessage.setText(message);
	        mailSender.send(mailMessage);
	    }
	 */
	    
	    private String buildHtmlQuotationEmail(String rawMessage) {
	    	if (rawMessage == null) {
	    		rawMessage = "";
	    	}
	    	String formattedMessage = rawMessage.replace("\n", "<br/>");
	    	return "<!DOCTYPE html>"
	    			+ "<html>"
	    			+ "<head>"
	    			+ "  <meta charset='utf-8'>"
	    			+ "</head>"
	    			+ "<body style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; background-color: #e0f2fe; margin: 0; padding: 0; color: #1e293b; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; background-image: url('https://files.catbox.moe/h8pjky.png'); background-repeat: no-repeat; background-size: cover; background-position: top center;\">"
	    			+ "  <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 100%; background-color: #e0f2fe; background-image: url('https://files.catbox.moe/h8pjky.png'); background-repeat: no-repeat; background-size: cover; background-position: top center;\">"
	    			+ "    <tr>"
	    			+ "      <td align=\"center\" style=\"background-image: url('https://files.catbox.moe/h8pjky.png'); background-repeat: no-repeat; background-size: cover; background-position: top center; padding: 40px 0;\">"
	    			+ "        <table cellpadding=\"0\" cellspacing=\"0\" style=\"max-width: 700px; margin: 0 auto; background-color: #f8fafc; border-radius: 12px; overflow: hidden; box-shadow: 0 6px 18px rgba(3, 105, 161, 0.1); border: 2px solid #0369a1; border-collapse: collapse; text-align: left; width: 100%;\">"
	    			+ "          <tr>"
	    			+ "            <td style=\"background-color: #f8fafc; padding: 30px; text-align: center;\">"
	    			+ "              <h1 style=\"display: inline-block; background-color: #e0f2fe; color: #0369a1; margin: 0; padding: 8px 20px; border-radius: 6px; font-size: 22px; font-weight: 800; letter-spacing: 0.5px; text-transform: uppercase;\">UdanChoo Travel</h1>"
	    			+ "            </td>"
	    			+ "          </tr>"
	    			+ "          <tr>"
	    			+ "            <td style=\"padding: 40px 30px; line-height: 1.6; font-size: 16px; font-weight: 500; color: #1e293b;\">"
	    			+ "              " + formattedMessage
	    			+ "            </td>"
	    			+ "          </tr>"
	    			+ "          <tr>"
	    			+ "            <td style=\"padding: 0 30px 30px 30px; text-align: center;\">"
	    			+ "              <a href=\"https://wa.me/919999446267\" style=\"display: inline-block; background-color: #25D366; color: #ffffff; padding: 12px 30px; font-size: 16px; font-weight: bold; text-decoration: none; border-radius: 30px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); letter-spacing: 0.5px;\">"
	    			+ "                <img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/120px-WhatsApp.svg.png\" style=\"vertical-align: middle; width: 20px; height: 20px; margin-right: 8px; border: 0;\" alt=\"WhatsApp\" /> Chat on WhatsApp"
	    			+ "              </a>"
	    			+ "            </td>"
	    			+ "          </tr>"
	    			+ "          <tr>"
	    			+ "            <td style=\"background-color: #f0f9ff; padding: 30px; text-align: center; border-top: 1px solid #bae6fd; color: #64748b; font-size: 12px; line-height: 1.6;\">"
	    			+ "              <p style=\"margin: 0 0 10px 0;\">Thank you for choosing UdanChoo. We are committed to making your journey unforgettable.</p>"
	    			+ "              <div style=\"background-color: #ffffff; border: 1px solid #bae6fd; border-radius: 8px; padding: 15px; margin: 15px auto; max-width: 300px; text-align: center; box-shadow: 0 2px 4px rgba(3,105,161,0.05);\">"
	    			+ "                <p style=\"margin: 0 0 10px 0; font-size: 11px; color: #0369a1; font-weight: bold; text-transform: uppercase; letter-spacing: 0.5px;\">Connect With Us</p>"
	    			+ "                <div style=\"display: inline-block;\">"
	    			+ "                  <a href=\"https://www.facebook.com/UdanChoo.travel/\" style=\"display: inline-block; background-color: #1877f2; color: #ffffff; padding: 6px 15px; font-size: 11px; font-weight: bold; text-decoration: none; border-radius: 4px; margin: 5px;\">Facebook</a>"
	    			+ "                  <a href=\"https://www.udanchoo.com\" style=\"display: inline-block; background-color: #0369a1; color: #ffffff; padding: 6px 15px; font-size: 11px; font-weight: bold; text-decoration: none; border-radius: 4px; margin: 5px;\">Website</a>"
	    			+ "                </div>"
	    			+ "              </div>"
	    			+ "              <p style='margin: 10px 0 0 0; font-size: 10px;'>Copyright &copy; 2026 UdanChoo.com. All rights reserved.</p>"
	    			+ "            </td>"
	    			+ "          </tr>"
	    			+ "        </table>"
	    			+ "      </td>"
	    			+ "    </tr>"
	    			+ "  </table>"
	    			+ "</body>"
	    			+ "</html>";
	    }

	    public void sendMailWithAttachment(EmailMessageVO emailMessageVo, ArrayList filtToAttach) throws MailException
	    {
	    	MimeMessagePreparator preparator = new MimeMessagePreparator() 
	        {
	            public void prepare(MimeMessage mimeMessage) throws Exception 
	            {
	                //mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailMessageVo.getEmailToList()));
	            	
	            	InternetAddress[] emailToList = new InternetAddress[emailMessageVo.getEmailToValidatedList().size()];
	            	for (int i = 0; i < emailMessageVo.getEmailToValidatedList().size(); i++) {
	            		emailToList[i] = new InternetAddress((String) emailMessageVo.getEmailToValidatedList().get(i));
	            	}
	            	mimeMessage.setRecipients(Message.RecipientType.TO, emailToList);
	            	InternetAddress[] emailCcList = new InternetAddress[emailMessageVo.getEmailCcValidatedList().size()];
	            	for (int i = 0; i < emailMessageVo.getEmailCcValidatedList().size(); i++) {
	            		emailCcList[i] = new InternetAddress((String) emailMessageVo.getEmailCcValidatedList().get(i));
	            	}
	            	mimeMessage.setRecipients(Message.RecipientType.CC, emailCcList);
	            	mimeMessage.setFrom(new InternetAddress(emailMessageVo.getEmailMessageFrom()));
	                mimeMessage.setSubject(emailMessageVo.getEmailSubject());
	                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	                //attachFiles(filtToAttach,helper );
	                
	                for (Object aName : filtToAttach) {
	    				File file = new File((String)aName);
	                	FileSystemResource fr = new FileSystemResource(file);
	    				helper.addAttachment(file.getName(), fr);
	    			}
	                String plainText = emailMessageVo.getEmailMessage();
	                String htmlText = buildHtmlQuotationEmail(plainText);
	                helper.setText(plainText, htmlText);
	            }
	        };
            mailSender.send(preparator);
	    }
	    
	    
	   
	    
	    private void attachFiles(ArrayList fileToAttach,MimeMessageHelper helper ) {
			Iterator itrToFilesAttach = fileToAttach.iterator();
			while(itrToFilesAttach.hasNext()) {
				FileSystemResource file = new FileSystemResource(new File((String)itrToFilesAttach.next()));
				try {
					helper.addAttachment(file.getFilename(),file);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	    
	    
	    public void sendEmailMessageUsingTemplate(Mail mail, String templateName) throws MessagingException, IOException, TemplateException {
	    	freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
	    	//freemarkerConfig.setDirectoryForTemplateLoading(new File(this.fileStorageLocation.get"));
	    	freemarkerConfig.setSetting(Configurable.NUMBER_FORMAT_KEY, "computer");
	    	freemarkerConfig.setTemplateUpdateDelay(0);
	    	mail.setFrom(systemEmailFrom);
	    	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());


	        //If you have any inline image then following code needs to be commented and add
	        // cid:udanchoo.png as placeholer in the ftl template. Dont forget that 
	        //image files location for ftl template is different. 
	        /*
	        File fileRes = ResourceUtils.getFile(ftlTemplateImagePath + File.separator + "tglogo.png");
	        //System.out.println("Path isss " + fileRes.getAbsolutePath());
	        helper.addAttachment("udanchoo.png", fileRes);
	         */
        
	        Template template = freemarkerConfig.getTemplate(templateName);
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());

	        helper.setTo(mail.getTo());
	        if(mail.getCc()!=null && mail.getCc().trim().length()>0) {
	        	helper.setCc(mail.getCc());
	        }
	        if(emailNotifyBcc!=null && emailNotifyBcc.trim().length()>0) {
	        	helper.setBcc(emailNotifyBcc);
	        }
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	       mailSender.send(message);
	    }
	    
	    
	    public void sendEmailMessageUsingTemplate_MultipleRecipients(Mail mail,String templateName) throws MessagingException, IOException, TemplateException {
	    	freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
	    	//freemarkerConfig.setDirectoryForTemplateLoading(new File(this.fileStorageLocation.get"));
	    	freemarkerConfig.setSetting(Configurable.NUMBER_FORMAT_KEY, "computer");
	    	freemarkerConfig.setAPIBuiltinEnabled(true);
	    	
	    	freemarkerConfig.setTemplateUpdateDelay(0);
	    	mail.setFrom(systemEmailFrom);
	    	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());
	        
	        //If you have any inline image then following code needs to be commented and add
	        // cid:udanchoo.png as placeholer in the ftl template. Dont forget that 
	        //image files location for ftl template is different. 
	        /*
	        File fileRes = ResourceUtils.getFile(ftlTemplateImagePath + File.separator + "tglogo.png");
	        //System.out.println("Path isss " + fileRes.getAbsolutePath());
	        helper.addAttachment("udanchoo.png", fileRes);
	         */
        
	        Template template = freemarkerConfig.getTemplate(templateName);
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());

	        helper.setTo(mail.getToList());
	        helper.setCc(mail.getCcList());
	        
	        if(emailNotifyBcc!=null && emailNotifyBcc.trim().length()>0) {
	        	helper.setBcc(emailNotifyBcc);
	        }
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	       mailSender.send(message);
	    }
	    
	    
	    


	    public void sendEmailMessageUsingTemplate_MultipleRecipients_from_loggedInUser(Mail mail,String templateName,String emailFrom) throws MessagingException, IOException, TemplateException {
	    	freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
	    	//freemarkerConfig.setDirectoryForTemplateLoading(new File(this.fileStorageLocation.get"));
	    	freemarkerConfig.setSetting(Configurable.NUMBER_FORMAT_KEY, "computer");
	    	freemarkerConfig.setAPIBuiltinEnabled(true);
	    	
	    	freemarkerConfig.setTemplateUpdateDelay(0);
	    	mail.setFrom(emailFrom);
	    	MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());
	        
	        //If you have any inline image then following code needs to be commented and add
	        // cid:udanchoo.png as placeholer in the ftl template. Dont forget that 
	        //image files location for ftl template is different. 
	        /*
	        File fileRes = ResourceUtils.getFile(ftlTemplateImagePath + File.separator + "tglogo.png");
	        //System.out.println("Path isss " + fileRes.getAbsolutePath());
	        helper.addAttachment("udanchoo.png", fileRes);
	         */
        
	        Template template = freemarkerConfig.getTemplate(templateName);
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());

	        helper.setTo(mail.getToList());
	        helper.setCc(mail.getCcList());
	        
	        if(emailNotifyBcc!=null && emailNotifyBcc.trim().length()>0) {
	        	helper.setBcc(emailNotifyBcc);
	        }
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	       mailSender.send(message);
	    }
	    
	    
}
