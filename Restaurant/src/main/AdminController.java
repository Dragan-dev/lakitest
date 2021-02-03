package main;
import java.security.Security;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
//|Spring version 5.2.3


@Controller
@RequestMapping("/administration")
public class AdminController {

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
	
	
//toFront statement
	@RequestMapping("/toFront")
	public String goToRestaurantly() {
		return"redirect:/index-page";
	}	
	
	
//Reservation----------- 
		
	@RequestMapping("/reservation-list")
	public String getReservationList(Model model) {
		List<Reservation> resList=reservationDAO.getReservationList();
		model.addAttribute("reservationCount",reservationDAO.getUnreadResCount());
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("resList", resList);
		return"reservation-list";
	}

	@RequestMapping("delete-reservation")
	public String deleteReservation(@RequestParam int id) {
		// This deletes a reservation based on the provided ID
		reservationDAO.deleteReservation(id);
		return "redirect:/administration/reservation-list";
	}
	
	@RequestMapping("reservation-seen")
	public String getMarkReservationSeen(@RequestParam int id) {
		Reservation r=reservationDAO.getReservation(id);
		r.setIsRead(true);
		reservationDAO.saveReservation(r);
		return"redirect:reservation-list";
	}
	
//Menu---------------
	@RequestMapping("/menu")
	public String getMenuPage(Model model) {
		List<Food> menuList=foodDAO.getFoodList();
			List<Category> catList=categoryDAO.getCategoryList();
			model.addAttribute("catList", catList);
			model.addAttribute("reservationCount",reservationDAO.getUnreadResCount());
			model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
			model.addAttribute("menuList", menuList);
			return"menu";
		}
	//form for creating new food
	
	@RequestMapping("/menu-form")
	public String getMenuForm(Model model) {
		
		model.addAttribute("reservationCount",reservationDAO.getUnreadResCount());
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("food",new Food());
		return"menu-form";
	}
	//update form for food
	
	@RequestMapping("/menu-form-update")
	public String getMenuFormUpdate(@RequestParam int id, Model model) {
		
		Food food=foodDAO.getFood(id);
		model.addAttribute("reservationCount",reservationDAO.getUnreadResCount());
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("food",food);
		return "menu-form";
	}
	
	@RequestMapping("menu-save")
	public String saveMenu(@Valid @ModelAttribute Food food, BindingResult result, Model model) {
		model.addAttribute("reservationCount",reservationDAO.getUnreadResCount());
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
			if(result.hasErrors()) {
				return"menu-form";
			}
			
			foodDAO.saveFood(food);
			return "redirect:/administration/menu";		
		}
	

	@RequestMapping("menu-cancel")
	public String menuCancel() {
		return"redirect:/administration/menu";
	
	
	}

	@RequestMapping("/menu-delete")
	public String getMenuDelete(@RequestParam int id) {
	foodDAO.deleteFood(id);
	return"redirect:/administration/menu";
	}
	
	
//Message--------------

	@RequestMapping("/message-list")
	public String getMessageList(Model model) {
		List<Message> mesList=messageDAO.getMessageList();
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
		model.addAttribute("mesList", mesList);
		return "message-list";
	}
	
	@RequestMapping("message-seen")
	public String getMarkMessageSeen( @RequestParam int id) {
		Message m=messageDAO.getMessage(id);
		m.setisSeen(true);
		messageDAO.saveMessage(m);
		return "redirect:message-list";
	}
	
	@RequestMapping("message-delete")
	public String deleteMessage(@RequestParam int id) {
		messageDAO.deleteMessage(id);
		return "redirect:message-list";
	}
	
//Chefs------------------------------------------------------------
	@RequestMapping("/chef")
	public String getChefPage(Model model) {
		List<Chef> chefList=chefDAO.getChefList();
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
		model.addAttribute("chefList", chefList);
		return "chef";
	}
	
	@RequestMapping("chef-delete")
	public String deleteChef(@RequestParam int id, Model model) {
	model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
	model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
	chefDAO.deleteChef(id);
	return"redirect:chef";
	
	}
	
	@RequestMapping("chef-form")
	public String getChefForm(Model model) {
		model.addAttribute("chef", new Chef());
		return"chef-form";
	}
	
	@RequestMapping("chef-form-update")
	public String chefFormUpdate(@RequestParam int id, Model model) {
		model.addAttribute("chefUpd", chefDAO.getChef(id));
		model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
		model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
		return"chef-form";
	}
	
	
	@RequestMapping("chef-save")
	public String saveChef(@Valid @ModelAttribute Chef chef,BindingResult result ,Model model) {
		if(result.hasErrors()) {
			List<Chef> chefList=chefDAO.getChefList();
			model.addAttribute("chefList", chefList);
			return "redirect:chef";
		}
		chefDAO.saveChef(chef);
		
		return"redirect:chef";
	}
	@RequestMapping("chef-update-cancel")
	public String chefCancel() {
		return"redirect:chef-form";
	}

//Events-----------------------------------------------------------------
	
@RequestMapping("events-list")
public String getEventsList(Model model) {
	List<Events> eventsList=eventsDAO.getEventsList();
	model.addAttribute("eventsList",eventsList);
	model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
	model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
	return "events-list";
}

@RequestMapping("events-form")
public String getEventsForm(Model model) {
	model.addAttribute("events", new Events());
	return"events-form";
}


@RequestMapping("event-form-update")
public String eventFormUpdate(@RequestParam int id, Model model) {
	
	model.addAttribute("eventUpd", eventsDAO.getEvent(id));
	model.addAttribute("messageCount", messageDAO.getUnreadMessageCount());
	model.addAttribute("reservationCount", reservationDAO.getUnreadResCount());
	
	return "events-form";
}

@RequestMapping("event-save")
public String saveEvent(@Valid @ModelAttribute Events events, BindingResult result, Model model) {
	
	if(result.hasErrors()) {
		List<Events> eventsList=eventsDAO.getEventsList();
		model.addAttribute("eventList",eventsList);
		return "redirect:events-list";
	}
	eventsDAO.saveEvent(events);
	return"redirect:events-list";
}

@RequestMapping("events-update-cancel")
public String eventsCancel() {
	return"redirect:events-list";
}

@RequestMapping("events-delete")
	public String deleteEvent(@RequestParam int id ) {
	eventsDAO.deleteEvent(id);
	return"events-list";
}

}
	
	

