package info.chhaileng.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.chhaileng.app.controller.SocketIOController;
import info.chhaileng.app.model.Price;
import info.chhaileng.app.repository.PriceRepository;

@RestController
public class APIController {
	
	@Autowired
	private SocketIOController socketIOController;
	
	@Autowired
	private PriceRepository priceRepository;
	
	@PostMapping("/api/v1/bid")
	public boolean bid(@RequestBody Price price) {
		if (price.getPrice() > priceRepository.findPrice().getPrice()) {
			priceRepository.setPrice(price);
//			socketIOController.broadcastEvent("onBid", priceRepository.findPrice());
			return true;
		}
		return false;
	}

}
