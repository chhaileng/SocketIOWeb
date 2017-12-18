package info.chhaileng.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.chhaileng.app.model.Price;
import info.chhaileng.app.repository.PriceRepository;
import info.chhaileng.app.service.NotificationService;

@Controller
public class MyController {
	
	@Autowired
	private SocketIOController socketIOController;
	
	@Autowired
	private NotificationService notification;
	
	@Autowired
	private PriceRepository priceRepository;
	
	@RequestMapping({"/", "/bid"})
	public String home(ModelMap m) {
		m.addAttribute("price", priceRepository.findPrice());
		return "index";
	}
	
	@PostMapping("/bid")
	public String bid(ModelMap m, @ModelAttribute("price") Price price) {
		
		if (price.getPrice() > priceRepository.findPrice().getPrice()) {
			priceRepository.setPrice(price);
			socketIOController.broadcastEvent("onBid", priceRepository.findPrice());
			notification.push("Someone bid on auction. The price is $" + priceRepository.findPrice().getPrice());
		}
		m.addAttribute("price", priceRepository.findPrice());
		return "redirect:/";
	}
	
	@GetMapping("/stop")
	@ResponseBody
	public String stopSocket() {
		socketIOController.stopServer();
		return "Stop Socket server...";
	}
	

}
