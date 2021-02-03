package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Events", schema = "restoran12")
public class Events {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String eventName;
	@Column
	private String description;
	@Column
	private int price;
	@Column
	private String picture;
	
		
	public Events() {
		
	}
	
	public Events(int id, String eventName, String description, int price, String picture) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.description = description;
		this.price = price;
		this.picture = picture;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public int getId() {
		return id;
	}
		
	
	
	
	
	
	
}
