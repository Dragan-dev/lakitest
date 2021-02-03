package main.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category" , schema = "restoran12")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String catName;
	@OneToMany(mappedBy = "category")
	private List<Food> foodList;
	
	public Category() {
		
	}
	
	public Category(String catName, int id) {
		this.id=id;
		this.catName=catName;	
		}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
			this.id=id;
	}	
	
	public String getcatName() {
		return this.catName;
	}
	
	public void setcatName(String catName) {
		this.catName=catName;
	}
	
	public void setfoodList(List<Food>foodList) {
		this.foodList=foodList;
	}
	
	public List<Food> getfoodList(){
		return this.foodList;
	}
	
	
	
}
