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
	                mimeMessage.setText(emailMessageVo.getEmailMessage());
	                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	                //attachFiles(filtToAttach,helper );
	                
	                for (Object aName : filtToAttach) {
	    				File file = new File((String)aName);
	                	FileSystemResource fr = new FileSystemResource(file);
	    				helper.addAttachment(file.getName(), fr);
	    			}
	                helper.setText(emailMessageVo.getEmailMessage());
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
