package main.DAO;
import java.util.List;

import main.entity.Chef;
public interface ChefDAO {

	public List<Chef> getChefList();
	public void deleteChef(int id);
	public void saveChef(Chef chef);
	public Chef getChef(int id);
	
}
