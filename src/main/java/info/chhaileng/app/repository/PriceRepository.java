package info.chhaileng.app.repository;

import org.springframework.stereotype.Repository;

import info.chhaileng.app.model.Price;

@Repository
public class PriceRepository {
	private Price price;
	
	public PriceRepository() {
		price = new Price(1);
	}
	
	public Price findPrice() {
		return price;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
}
