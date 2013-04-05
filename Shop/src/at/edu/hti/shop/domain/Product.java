package at.edu.hti.shop.domain;

public class Product {
	private String name;
	private long id;
	private double prize;
	
	private int deliveryTimeInDays;
	private double weight;
	private String productGroup;
	

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public int getDeliveryTimeInDays() {
		return deliveryTimeInDays;
	}

	public void setDeliveryTimeInDays(int deliveryTimeInDays) {
		this.deliveryTimeInDays = deliveryTimeInDays;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Product( long id, String name, double prize, int deliveryTimeInDays, double weight, String productGroup) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.deliveryTimeInDays = deliveryTimeInDays;
		this.weight = weight;
		this.productGroup = productGroup;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", id " + id + ", price " + prize + ", weight " + weight +
				", productGroup " + productGroup + ", deliveryTimeInDays " + deliveryTimeInDays + "]";
	}

}
