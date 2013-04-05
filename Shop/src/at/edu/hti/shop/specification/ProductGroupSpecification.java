package at.edu.hti.shop.specification;

import at.edu.hti.shop.domain.Product;

public class ProductGroupSpecification extends CompositeSpecification<Product> {

	private String productGroup;
	
	
	public ProductGroupSpecification(String productGroup) {
		super();
		this.productGroup = productGroup;
	}


	@Override
	public boolean IsSatisfiedBy(Product candidate) {
		return null == productGroup ? true : candidate.getProductGroup().equalsIgnoreCase(productGroup);
	}

}
