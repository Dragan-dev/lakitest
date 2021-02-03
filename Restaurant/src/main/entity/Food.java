package main.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "food" , schema = "restoran12")
public class Food {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	@NotEmpty(message = "Required")
	private String name;
	@Column
	@NotEmpty(message = "Set price")
	private String price;
	@Column
	private String image;
	@Column
	@NotEmpty(message = "min:10 max: 50 char")
	private String description;
	@Column
	private boolean isOnIndexPage;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "id_category")
	private Category category;
	
	public Food() {
		 
				}

			public Food(int id, String name, String price, Category category,String image, String description,boolean isOnIndexPage) {
				this.id = id;
				this.name = name;
				this.price = price;
				this.image = image;
				this.description = description;
				this.category=category;
				this.isOnIndexPage=isOnIndexPage;
			
			}

			public boolean getIsOnIndexPage() {
				return isOnIndexPage;
			}

			public void setIsOnIndexPage(boolean isOnIndexPage) {
				this.isOnIndexPage = isOnIndexPage;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}


			public String getPrice() {
				return price;
			}

			public void setPrice(String price) {
				this.price = price;
			}

			public String getImage() {
				return image;
			}

			public void setImage(String image) {
				this.image = image;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public int getId() {
				return id;
			}
			
			public Category getCategory() {
				return this.category;
			}

			public void setCategory(Category category) {
				this.category=category;
			}
			
		@Override
		public String toString() {
		
		return "("+id+") " + name+ ", ";
	}
}

	
