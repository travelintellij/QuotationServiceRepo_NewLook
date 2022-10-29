package com.travelintellij.quotation.model;

import java.util.Map;

import javax.mail.internet.InternetAddress;

public class Mail {

    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String content;
    private InternetAddress[] toList;
    private InternetAddress[] ccList;
    
    
    Map<String, Object> model ;
    public Mail() {
    }

    public Mail(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public InternetAddress[] getToList() {
		return toList;
	}

	public void setToList(InternetAddress[] toList) {
		this.toList = toList;
	}

	public InternetAddress[] getCcList() {
		return ccList;
	}

	public void setCcList(InternetAddress[] ccList) {
		this.ccList = ccList;
	}
    
    
}
 