package at.edu.hti.shop.specification;

import at.edu.hti.shop.domain.Product;

public class WeightSpecification extends CompositeSpecification<Product> {

	private Integer maxWeight;
	
	
	public WeightSpecification(Integer maxWeight) {
		super();
		this.maxWeight = maxWeight;
	}


	@Override
	public boolean IsSatisfiedBy(Product candidate) {
		return null == maxWeight ? true : candidate.getWeight() < maxWeight;
	}

}
