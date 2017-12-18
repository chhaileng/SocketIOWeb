package info.chhaileng.app.model;

public class Price {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Price(double price) {
		this.price = price;
	}
	public Price() {
		this.price = 0;
	}

	@Override
	public String toString() {
		return "Price [price=" + price + "]";
	}
	
}
