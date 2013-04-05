package at.edu.hti.shop.specification;

import at.edu.hti.shop.domain.Product;

public class DeliveryTimeInDaysSpecification extends CompositeSpecification<Product> {

	private Integer deliveryTimeInDays;
	
	
	public DeliveryTimeInDaysSpecification(Integer deliveryTimeInDays) {
		super();
		this.deliveryTimeInDays = deliveryTimeInDays;
	}


	@Override
	public boolean IsSatisfiedBy(Product candidate) {
		return null == deliveryTimeInDays ? true : candidate.getDeliveryTimeInDays() < deliveryTimeInDays;
	}

}
