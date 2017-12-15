package info.chhaileng.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import info.chhaileng.app.model.Price;

@Controller
public class MyController {
	
	@Autowired
	private SocketIOController socketIOController;
	
	private Price price = new Price(0);
	
	@RequestMapping({"/", "/bid"})
	public String home(ModelMap m) {
		m.addAttribute("price", price);
		return "index";
	}
	
	@PostMapping("/bid")
	public String bid(ModelMap m, @ModelAttribute("price") Price p) {
		
		if (p.getPrice() > price.getPrice()) {
			price = p;
			socketIOController.broadcastEvent("onBid", price);
		}
		m.addAttribute("price", price);
		return "redirect:/";
	}

}
