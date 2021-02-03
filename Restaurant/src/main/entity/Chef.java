package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "chefs" , schema = "restoran12")
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String picture;
	@Column
	private String rank;



	public Chef() {
	}

	public Chef(int id, String name, String picture, String rank) {
		this.id=id;
		this.name=name;
		this.picture=picture;
		this.rank=rank;
	}
	
	
	public int getId() {
		return this.id;
		
	}
	 public void setId(int id) {
		 this.id=id;
		 
	 }

	 public String getName() {
		 return this.name;
	 }

	 public void setName(String name) {
		 this.name=name;
		 
	 }

	 public String getPicture() {
		 return this.picture;
	 }

	 public void setPicture(String picture) {
		 this.picture=picture;
	 }

	 public String getRank() {
		 return this.rank;
	 }
	 
	 public void setRank(String rank) {
		 this.rank=rank;
	 }
	 

@Override
public String toString() {
	
	return "(" +id+ ")" + name;
}





}