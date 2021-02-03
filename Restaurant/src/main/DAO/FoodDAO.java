package main.DAO;

import java.util.List;
import main.entity.Food;

public interface FoodDAO {

	public Food getFood(int id);
	public List<Food> getFoodList();
	public void deleteFood(int id);
	public  void saveFood(Food food);
	public List<Food> getFoodByCategory(int id);
	public List<Food> getFoodsOnIndexPage();

	
	
}
