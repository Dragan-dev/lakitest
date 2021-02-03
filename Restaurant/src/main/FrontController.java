package main;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import main.DAO.CategoryDAO;
import main.DAO.ChefDAO;
import main.DAO.EventsDAO;
import main.DAO.FoodDAO;
import main.DAO.MessageDAO;
import main.DAO.ReservationDAO;
import main.entity.Category;
import main.entity.Chef;
import main.entity.Events;
import main.entity.Food;
import main.entity.Message;
import main.entity.Reservation;

@Controller
@RequestMapping("/")
public class FrontController {

	@Autowired
	private ReservationDAO reservationDAO;
	@Autowired
	private FoodDAO foodDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private ChefDAO chefDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private EventsDAO eventsDAO;
	
//index page	
	@RequestMapping({"/","/index-page"})
	public String getIndexPage(Model model) {
		List<Food> foodList1=foodDAO.getFoodByCategory(1);
		List<Food> foodList2=foodDAO.getFoodByCategory(2);
		List<Food> foodList3=foodDAO.getFoodByCategory(3);

		List<Food> foodOnIndex=foodDAO.getFoodsOnIndexPage();
		List<Chef> chefList=chefDAO.getChefList();
		List<Category> categoryList=categoryDAO.getCategoryList();
		List<Events> eventsList=eventsDAO.getEventsList();

		model.addAttribute("foodList1", foodList1);
		model.addAttribute("foodList2", foodList2);
		model.addAttribute("foodList3", foodList3);



		model.addAttribute("eventsList", eventsList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("chefList",chefList);
		model.addAttribute("foodOnIndex", foodOnIndex);
		
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("message", new Message());
		
		return "front/index-page";
	}

	
//res save method---------
	
@RequestMapping("reservation-save")
		public String reservationSave(@Valid @ModelAttribute Reservation reservation, BindingResult result) {
		
		if(result.hasErrors()){
			return "front/index-page";
		}
		reservationDAO.saveReservation(reservation);
		return "redirect:/index-page";
	}

 
//message save
	@RequestMapping("message-save")
	 public String messageSave(@Valid @ModelAttribute Message message, BindingResult result) {
		
		if(result.hasErrors()) {
			return "front/index-page";
		}
		messageDAO.saveMessage(message);
		return "redirect:/index-page";
	}

//menu by category
	
	
	
}







