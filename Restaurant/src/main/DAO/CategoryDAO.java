package main.DAO;

import java.util.List;

import main.entity.Category;

public interface CategoryDAO {

	public Category getCategory(int id );
	public List<Category> getCategoryList();
	public void deleteCategory(int id);
	public void saveCategory(Category category);
}
