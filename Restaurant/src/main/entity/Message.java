package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "message", schema = "restoran12")
public class Message {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String yourName;
	@Column
	@NotEmpty(message = "please enter Email")
	private String yourEmail;
	@Column
	private String subject;
	@Column
	@NotEmpty(message = "please enter Message ")
	private String messageText;
	@Column
	private boolean isSeen;
	
	
	public Message() {
		
	}
	
	
	public Message(boolean isSeen,int id, String yourName, String yourEmail, String subject, String messageText) {
		super();
		this.id = id;
		this.yourName = yourName;
		this.yourEmail = yourEmail;
		this.subject = subject;
		this.messageText = messageText;
		this.isSeen=isSeen;
	}
	
	
	public String getYourName() {
		return yourName;
	}
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}
	public String getYourEmail() {
		return yourEmail;
	}
	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return messageText;
	}
	public void setMessage(String message) {
		this.messageText = message;
	}
	public int getId() {
		return id;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public boolean getisSeen() {
		return isSeen;
	}
	public void setisSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}
	
	
}
