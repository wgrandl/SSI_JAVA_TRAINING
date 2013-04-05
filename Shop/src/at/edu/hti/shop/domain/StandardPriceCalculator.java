package at.edu.hti.shop.domain;

import java.util.List;

public class StandardPriceCalculator implements PriceCalcucationable {
		
	public double calculatePrice(List<OrderLine> lines) {
		
		double sum = 0;

		for(OrderLine line : lines ) {
			sum += line.getProduct().getPrize()* line.getAmount() ;
		}
		
		return 0;
	}

}
