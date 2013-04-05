package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

import at.edu.hti.shop.specification.DeliveryTimeInDaysSpecification;
import at.edu.hti.shop.specification.ISpecification;
import at.edu.hti.shop.specification.ProductGroupSpecification;
import at.edu.hti.shop.specification.WeightSpecification;

public class OrderSplitAble extends Order {

	public List<List<OrderLine>> getOrderLinesGroupedByMaxWeight( int maxWeight ) {
		List<List<OrderLine>> linesGrouped = new ArrayList<List<OrderLine>>();
		
		List<OrderLine> linesMatched = new ArrayList<OrderLine>();
		List<OrderLine> linesNotMatched = new ArrayList<OrderLine>();
		
		WeightSpecification weightSpec = new WeightSpecification( maxWeight );
		for( OrderLine ol : orderLines ) {
			if( weightSpec.IsSatisfiedBy( ol.getProduct())) {
				linesMatched.add(ol);
			} else {
				linesNotMatched.add(ol);				
			}
		}
		
		linesGrouped.add(linesMatched);
		linesGrouped.add(linesNotMatched);
		
		return linesGrouped;
	}
	
	
	public List<List<OrderLine>> getOrderLinesGrouped( Integer maxWeight, String productGroup, Integer deliveryTimeInDays ) {
		List<List<OrderLine>> linesGrouped = new ArrayList<List<OrderLine>>();
		
		List<OrderLine> linesMatched = new ArrayList<OrderLine>();
		List<OrderLine> linesNotMatched = new ArrayList<OrderLine>();
	
		WeightSpecification weightSpec = new WeightSpecification( maxWeight );
		ProductGroupSpecification productGroupSpec = new ProductGroupSpecification( productGroup );
		DeliveryTimeInDaysSpecification deliveryTimeInDaysGroupSpec = new DeliveryTimeInDaysSpecification( deliveryTimeInDays );
		
		ISpecification<Product> multiSpec = weightSpec.And(productGroupSpec).And(deliveryTimeInDaysGroupSpec);
	
		for( OrderLine ol : orderLines ) {
			if( multiSpec.IsSatisfiedBy(ol.getProduct()) ) {
				linesMatched.add(ol);
			} else {
				linesNotMatched.add(ol);				
			}
		}

		linesGrouped.add(linesMatched);
		linesGrouped.add(linesNotMatched);
		
		return linesGrouped;
	}
	
	
	public List<OrderLine> combineOrderParts(List<List<OrderLine>> linesGrouped) {
		List<OrderLine> linesCombined = new ArrayList<OrderLine>();
		
		for( List<OrderLine> linesGroup : linesGrouped ) {
			linesCombined.addAll(linesGroup);
		}

		return linesCombined;
	}
	
}
