package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "reservation", schema = "restoran12")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	@NotEmpty(message = "Please enter your name")
	@Size(min = 3, max = 10)
	private String name;
	@Column
	@NotEmpty(message = "Please enter email")
	private String email;
	@Column
	@NotEmpty(message = "Enter phone number")
	private String phone;
	@Column
	@NotEmpty(message = "Please set reservation date")
	private String date;
	@Column
	private int numberOfPeople;
	@Column
	private String message;
	@Column
	@NotNull
	public String time;
	@Column
	private boolean isRead;
	
	public Reservation() {
		
	}

	public Reservation(int id, String name, String email, String phone, String date, int numberOfPeople, String message,
			String time,boolean isRead) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.numberOfPeople = numberOfPeople;
		this.message = message;
		this.isRead = isRead;
		this.time=time;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time=time;
	}
	
	@Override
	public String toString() {
		
		return "(" +id+ ")" + email+", " +date+ ", "+numberOfPeople;
	}


}

